package old.T300_499;

public class T344 {
	public String reverseString(String s) {
        if(s == null || s.length() == 0)
            return s;
        char[] ca = s.toCharArray();
        int left = 0, right = ca.length - 1;
        while(left < right){
            char c = ca[left];
            ca[left] = ca[right];
            ca[right] = c;
            left++;
            right--;
        }
        
        return String.valueOf(ca);
    }
}
