package Z2025.T1_9;

public class T5 {
    public String longestPalindrome(String s) {
        String res = "";
        if(s == null || s.length() == 0){
            return res;
        }

        for(int i = 0; i < s.length(); i++){
            String s1 = expand(s, i, i);
            String s2 = expand(s, i, i + 1);

            if(s1.length() > res.length()){
                res = s1;
            }
            if(s2.length() > res.length()){
                res = s2;
            }
        }

        return res;
    }

    private String expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
