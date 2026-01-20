package old.C_Meta;

public class TTT125 {
	public boolean isPalindrome(String s){
		if(s == null || s.length() == 0) return true;
		int left = 0, right = s.length() - 1;
		while(left < right){
			char lc = s.charAt(left);
			char rc = s.charAt(right);
			if(!Character.isLetterOrDigit(lc)){
				left++;
			}
			else if(!Character.isLetterOrDigit(rc)){
				right--;
			}
			else{
				if(Character.toLowerCase(lc) != Character.toLowerCase(rc)){
					return false;
				}
				left++;
				right--;
			}
		}
		return true;
	}
}
