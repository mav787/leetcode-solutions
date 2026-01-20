package old.T1_99;

public class T5 {
	private int startIndex = 0, maxLen = 0;
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2)
            return s;
        for(int i = 0; i < s.length(); i++){
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return s.substring(startIndex, startIndex + maxLen);
    }
    
    private void extend(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        int currLen = right - left - 1;
        if(currLen > maxLen){
            maxLen = currLen;
            startIndex = left + 1;
        }
    }
}
