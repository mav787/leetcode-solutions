package old.C_Meta.T100_999;

public class T680 {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() <= 2){
            return true;
        }
        int left = 0, right = s.length() - 1;

        while(left <= right && s.charAt(left) == s.charAt(right)){
            left++;
            right--;
        }
        return isValidPalindrome(s, left + 1, right) || isValidPalindrome(s, left, right - 1);
    }

    private boolean isValidPalindrome(String s, int left, int right){
        while(left <= right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
