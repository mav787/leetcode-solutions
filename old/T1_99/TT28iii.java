package old.T1_99;

public class TT28iii {
	public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            if(haystack.substring(i, i + needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
