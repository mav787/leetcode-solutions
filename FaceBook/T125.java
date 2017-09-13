package FaceBook;

public class T125 {
	public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        		return true;
        }
//        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        char lc, rc;
        while(i <= j) {
	        	lc = s.charAt(i);
	        	rc = s.charAt(j);
	        	if (!Character.isLetterOrDigit(lc)) {
	        		i++;
	        	} else if(!Character.isLetterOrDigit(rc)) {
	        		j--;
	        	} else {
	        		if (Character.toLowerCase(lc) != Character.toLowerCase(rc)) {
//	        		if(lc != rc){
	        			return false;
	        		}
	        		i++;
	        		j--;
	        	}
        }
        return true;
    }
	
//	public static void main(String[] args){
//		T125 obj = new T125();
//		System.out.println(obj.isPalindrome("as;dlkjfPIWURET1234!@%$(*&%^)"));
//	}
}
