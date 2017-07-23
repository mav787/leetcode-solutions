package T100_199;
import java.util.*;

public class T127Opti {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = 0;
        
        Set<String> words = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        Set<String> begin = new HashSet<String>();
        Set<String> end = new HashSet<String>();
        
        for (String word : wordList) 
        	words.add(word);
        if (!words.contains(endWord)) 
        	return 0;
        
        begin.add(beginWord);
        end.add(endWord);
        length++;		// initialize : 1
        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {		// swap : begin.size() <= end.size()
                Set<String> temp = end;
                end = begin;
                begin = temp;
            }
            Set<String> next = new HashSet<String>();
            for (String w : begin) {
                visited.add(w);						// mark visited
                
                char[] chars = w.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) 
                        	continue;
                        chars[i] = c;
                        String v = new String(chars);
                        
                        if (end.contains(v)) 
                        	return length + 1;
                        if (words.contains(v) && !visited.contains(v)) {
                            next.add(v);			// true neighbor && unvisited
                        }
                    }
                    chars[i] = original;			// backtrack...
                }
            }
            begin = next;							// update variable
            length++;								// update length
        }
        return 0;
    }
}
