package Z2025.T10_99;

public class T65 {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        s = s.trim();
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c == 'e' || c == 'E'){
                break;
            }
            i++;
        }

        if(i == s.length()){
            return isInteger(s) || isDecimal(s);
        }
        else{
            String prefix = s.substring(0, i);
            String suffix = s.substring(i + 1);

            return (isInteger(prefix) || isDecimal(prefix)) && isInteger(suffix);
        }
    }

    private boolean isInteger(String s){
        s = s.trim();
        if(s.length() == 0){
            return false;
        }

        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            return isValid(s.substring(1));
        }

        return isValid(s);
    }

    private boolean isDecimal(String s){
        s = s.trim();
        if(s.length() == 0){
            return false;
        }

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '.'){
                String prefix = s.substring(0, i);
                String suffix = s.substring(i + 1);

                if(isEmpty(prefix) && isEmpty(suffix)){
                    return false;
                }

                if(!isEmpty(prefix) && !isInteger(prefix)){
                    return false;
                }
                if(!suffix.equals("") && !isValid(suffix)){
                    return false;
                }
                return true;
            }
        }
        return isInteger(s);
    }

    private boolean isEmpty(String s){
        return s.equals("")
                || s.equals("+")
                || s.equals("-");
    }

    private boolean isValid(String s){
        if(s.length() == 0){
            return false;
        }

        for(char c : s.toCharArray()){
            if(c < '0' || c > '9'){
                return false;
            }
        }

        return true;
    }
}
