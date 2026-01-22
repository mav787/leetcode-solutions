package Z2025.T100_999;
import java.util.*;

public class T127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        int res = 1;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String s = queue.poll();
                if(s.equals(endWord)){
                    return res;
                }

                char[] ca = s.toCharArray();
                for(int j = 0; j < ca.length; j++){
                    char cj = ca[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == cj){
                            continue;
                        }
                        ca[j] = c;
                        String cn = String.valueOf(ca);
                        if(dict.contains(cn)){
                            dict.remove(cn);
                            queue.offer(cn);
                        }
                    }
                    ca[j] = cj;
                }
            }
            res++;
        }

        return 0;
    }
}
