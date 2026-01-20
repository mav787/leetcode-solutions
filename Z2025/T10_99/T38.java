package Z2025.T10_99;

public class T38 {
    public String countAndSay(int n) {
        if(n < 1 || n > 30){
            return "";
        }

        String s = "1";
        for(int i = 1; i < n; i++){
            s = count(s);
        }
        return s;
    }

    private String count(String s){
        StringBuilder sb = new StringBuilder();
        char[] ca = s.toCharArray();
        int count = 1;
        char c = ca[0];

        for(int i = 1; i < ca.length; i++){
            if(ca[i] == ca[i - 1]){
                count++;
            }
            else{
                sb.append(count);
                sb.append(c);

                count = 1;
                c = ca[i];
            }
        }

        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}
