package C_Meta;
import java.util.*;


public class TTT127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size() == 0) return 0;
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        
        while(!queue.isEmpty()){
            String s = queue.poll();
            List<String> neighbors = getNeighbors(s, set);
            for(String nei : neighbors){
                if(nei.equals(endWord))
                    return map.get(s) + 1;
                else{
                    if(!map.containsKey(nei)){
                        map.put(nei, map.get(s) + 1);
                        queue.offer(nei);
                    }
                }
            }
        }
        return 0;
    }
    
    private List<String> getNeighbors(String s, Set<String> set){
        List<String> res = new ArrayList<>();
        char[] ca = s.toCharArray();
        for(int i = 0; i < ca.length; i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(c == s.charAt(i))
                    continue;
                ca[i] = c;
                String candidate = String.valueOf(ca);
                if(set.contains(candidate)){
                    res.add(candidate);    
                }
                ca[i] = s.charAt(i);        // backtrack...
            }
        }
        return res;
    }
}
