package Z2025.T10_99;

public class T58 {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        String[] sa = s.trim().split(" ");
        return sa.length == 0 ? 0 : sa[sa.length - 1].length();
    }
}
