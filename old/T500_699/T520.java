package old.T500_699;

public class T520 {
	public boolean detectCapitalUse(String word) {
        if (word.length() < 2) return true;
        if (word.toUpperCase().equals(word)) return true;
        if (word.substring(1).toLowerCase().equals(word.substring(1))) return true;
        return false;
    }
}
