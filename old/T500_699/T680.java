package old.T500_699;

public class T680 {
	public boolean validPalindrome(String s) {
        return validPalindrome(s, 1);
    }

    private boolean validPalindrome(String s, int count) {
        int len = s.length();
        for (int i = 0; i < len / 2; i ++)
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                if (count == 0) return false;
                else {
                    return validPalindrome(s.substring(i + 1, len - i), 0) || validPalindrome(s.substring(i, len - i - 1), 0);
                }
            }
        return true;
    }
    
//	public boolean validPalindrome(String s) {
//        if(s == null || s.length() == 0) return true;
//        char[] ca = s.toCharArray();
//        int left = 0, right = ca.length - 1;
//        int diff = 0;
//        while(left < right){
//            if(ca[left] == ca[right]){
//                left++;
//                right--;
//            }
//            else{
//                left++;
//                diff++;
//            }
//        }
//        if(diff <= 1) return true;
//        left = 0;
//        right = ca.length - 1;
//        diff = 0;
//        while(left < right){
//            if(ca[left] == ca[right]){
//                left++;
//                right--;
//            }
//            else{
//                right--;
//                diff++;
//            }
//        }
//        if(diff <= 1) return true;
//        return false;
//    }
}
