package old.T200_299;

public class T266 {
	public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        int[] dict = new int[256];
        for(int i = 0; i < s.length(); i++){
            int index = (int)(s.charAt(i));
            dict[index]++;
        }
        
        int count = 0;
        for(int i = 0; i < 256; i++){
            if(dict[i] % 2 != 0){
                count++;
            }
        }
        return count <= 1;
    }
}
