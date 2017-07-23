package T100_199;
import java.util.*;

public class T151 {
	public String reverseWords(String s) {
        if(s == null || s.length() == 0)
            return s;
        String[] sa = s.trim().split(" +");
        Collections.reverse(Arrays.asList(sa));
        return String.join(" ", sa);
    }
}
