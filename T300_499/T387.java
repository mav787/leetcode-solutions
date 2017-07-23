package T300_499;

public class T387 {
	public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        
        int len = s.length();
        int[] cnt = new int[26];
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            cnt[c - 'a']++;
        }
        
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(cnt[c - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
