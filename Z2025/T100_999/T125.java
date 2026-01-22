package Z2025.T100_999;

public class T125 {
    public boolean isPalindrome(String s) {
        if(s == null){
            return false;
        }
        String sp = process(s);

        char[] ca = sp.toCharArray();
        int left = 0, right = ca.length - 1;
        while(left < right){
            if(ca[left] != ca[right]){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private String process(String s){
        s = s.trim().toLowerCase();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // if(Character.isLetterOrDigit(c)){
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
