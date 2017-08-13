package T1_99;
import java.util.*;

public class TT68 {
	public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<String>();
        int index = 0;
        
        while (index < words.length) {
            int count = words[index].length();
            int next = index + 1;
            while (next < words.length) {
                if (words[next].length() + count + 1 > L) 
                	break;
                count += words[next].length() + 1;
                next++;
            }
            
            StringBuilder builder = new StringBuilder();
            int diff = next - index - 1;
            
            
            // if last line or number of words in the line is 1, left-justified
            if (next == words.length || diff == 0) {
                for (int i = index; i < next; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
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
