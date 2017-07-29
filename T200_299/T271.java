package T200_299;
import java.util.*;

public class T271 {
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
        for (String s : strs)
            sb.append(s.replace("#", "##")).append(" # ");	// replace & combine with divisor
        return sb.toString();
    }

	public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        String[] sa = s.split(" # ", -1);
        for (int i = 0; i < sa.length - 1; i++)				// skip the last element
            res.add(sa[i].replace("##", "#"));				// divide and replace back
        return res;
    }
}
