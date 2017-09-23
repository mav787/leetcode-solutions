package C_FaceBook;
import java.util.*;

public class TTT127My {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null || wordList.size() == 0) return 0;
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;

        int res = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
    
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int j = 0; j < size; j++){
                String s = queue.poll();
                if(s.equals(endWord)) return res + 1;   // length of path

                char[] ca = s.toCharArray();
                for(int i = 0; i < ca.length; i++){
                    char origin = ca[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == origin) continue;
                        ca[i] = c;
                        String next = String.valueOf(ca);
                        if(dict.contains(next)){
                            queue.offer(next);
                            dict.remove(next);
                        }
                    }
                    ca[i] = origin;
                }
            }
            res++;
        }
        return 0;
    }
}
