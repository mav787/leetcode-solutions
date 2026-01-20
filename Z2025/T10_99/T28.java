package Z2025.T10_99;

public class T28 {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length()){
            return -1;
        }

        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            if(check(haystack, i, needle)){
                return i;
            }
        }

        return -1;
    }

    private boolean check(String haystack, int start, String needle){
        for(int i = 0; i < needle.length(); i++){
            char ca = haystack.charAt(start + i);
            char cb = needle.charAt(i);
            if(ca != cb){
                return false;
            }
        }
        return true;
    }
}
