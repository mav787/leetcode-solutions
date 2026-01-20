package old.C_Meta;
import java.util.*;

public class TT68 {
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int curr = 0;
        
        while (curr < words.length) {
            int len = words[curr].length();
            int end = curr + 1;
            while (end < words.length) {
                if (len + 1 + words[end].length() > maxWidth) break;
                len += words[end].length() + 1;
                end++;
            }
            
            StringBuilder sb = new StringBuilder();
            int count = end - curr - 1;
            
            // if last line or number of words in the line is 1
            if (end == words.length || count == 0) {
            	// left justified
                for (int i = curr; i < end; i++) {
                    sb.append(words[i]).append(" ");
                }
                sb.setLength(sb.length() - 1);
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                // middle justified
                int spaces = (maxWidth - len) / count;
                int rest = (maxWidth - len) % count;
                for (int i = curr; i < end; i++) {
                    sb.append(words[i]);
                    if (i != end - 1) {
                        for (int j = 0; j <= (spaces + ((i - curr) < rest ? 1 : 0)); j++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            curr = end;
            res.add(sb.toString());
        }
        return res;
    }
}
