package old.T300_499;

public class T387 {
	public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        int[] dict = new int[256];
        for(int i = 0; i < s.length(); i++){
            dict[s.charAt(i)]++;
        }
        
        for(int i = 0; i < s.length(); i++){
            if(dict[s.charAt(i)] == 1)
                return i;
        }
        return -1;
    }
}
