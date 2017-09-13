package FaceBook;
import java.util.*;

public class T127Opti {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = 0;
        Set<String> dict = new HashSet<String>(wordList);
        Set<String> visited = new HashSet<String>();
        Set<String> begin = new HashSet<String>();
        Set<String> end = new HashSet<String>();
        
        if (!dict.contains(endWord)) return 0;
        
        begin.add(beginWord);
        end.add(endWord);
        length++;
        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                Set<String> temp = end;
                end = begin;
                begin = temp;
            }
            Set<String> next = new HashSet<String>();
            for (String w : begin) {
                visited.add(w);
                
                char[] ca = w.toCharArray();
                for (int i = 0; i < ca.length; i++) {
                    char original = ca[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        ca[i] = c;
                        String candidate = new String(ca);
                        if (end.contains(candidate)) return length + 1;
                        if (dict.contains(candidate) && !visited.contains(candidate)) {
                            next.add(candidate);
                        }
                    }
                    ca[i] = original;
                }
            }
            begin = next;
            length++;
        }
        return 0;
    }
}
