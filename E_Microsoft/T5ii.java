package E_Microsoft;

public class T5ii {
	public String longestPalindrome(String s) {
        if(s == null || s.length() < 2) return s;
        int maxLen = 1;
        int index = 0;
        
        for(int i = 0; i < s.length(); i++){
            int len1 = extend(s, i, i);
            int len2 = extend(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len >= maxLen){
                maxLen = len;
                index = i;
            }
        }
        return s.substring(index - (maxLen - 1) / 2, index + maxLen / 2 + 1);
    }
    
    private int extend(String s, int left, int right){
        if(left < 0 || right >= s.length()) return -1;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
