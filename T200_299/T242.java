package T200_299;

public class T242 {
	public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;
        int[] dict = new int[26];
        for(int i = 0; i < s.length(); i++){
            dict[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            dict[t.charAt(i) - 'a']--;
            if(dict[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
}
