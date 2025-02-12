package D_Microsoft.T1_9;

public class T5 {
    int start = 0;
    int end = 0;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        for(int i = 0; i < s.length(); i++){
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return s.substring(start, end + 1);
    }

    private void expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            int length = right - left + 1;
            if(length >= end - start + 1){
                start = left;
                end = right;
            }
            left--;
            right++;
        }
    }
}
