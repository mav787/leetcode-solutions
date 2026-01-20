package old.T1_99;
import java.util.*;

public class TT68 {
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int index = 0;
        
        while (index < words.length) {
            int levelLen = words[index].length();
            int next = index + 1;
            while (next < words.length) {
                if (words[next].length() + levelLen + 1 > maxWidth) 
                	break;
                levelLen += words[next].length() + 1;
                next++;
            }
            
            StringBuilder builder = new StringBuilder();
            int count = next - index - 1;
            
            
            // if last line or number of words in the line is 1, left-justified
            if (next == words.length || count == 0) {
                for (int i = index; i < next; i++) {
                    builder.append(words[i] + " ");
                }
                builder.setLength(builder.length() - 1);
                for (int i = builder.length(); i < maxWidth; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (maxWidth - levelLen) / count;
                int r = (maxWidth - levelLen) % count;
                for (int i = index; i < next; i++) {
                    builder.append(words[i]);
                    if (i < next - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            res.add(builder.toString());
            index = next;
        }
        return res;
    }
}
