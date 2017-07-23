package T1_99;

public class TT58 {
	public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)
            return 0;
        s = s.trim();
        String[] sa = s.split(" ");
        if(sa.length == 0)
            return 0;
        return sa[sa.length - 1].length();
    }
}
