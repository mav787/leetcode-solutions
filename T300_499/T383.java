package T300_499;

public class T383 {
	public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null || ransomNote.length() > magazine.length()) return false;
        int[] dict = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            dict[magazine.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < ransomNote.length(); i++){
            dict[ransomNote.charAt(i) - 'a']--;
            if(dict[ransomNote.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
