package old.T500_699;
import java.util.*;

public class T642My {
	private Map<String, Integer> map;
    private TrieNode root;
    private TrieNode curr;
    private StringBuilder sb;

    public T642My(String[] sentences, int[] times) {
        map = new HashMap<>();
        root = new TrieNode(null);
        curr = root;
        for(int i = 0; i < times.length; i++){
            map.put(sentences[i], times[i]);
            insert(sentences[i]);
        }
        sb = new StringBuilder();
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if(c == '#'){
            String newWord = sb.toString();
            sb.setLength(0);
            if(map.containsKey(newWord)){
                map.put(newWord, map.get(newWord) + 1);
                curr = root;
            }
            else{
                map.put(newWord, 1);
                while(curr != null){
                    curr.insert(newWord);
                    curr = curr.parent;
                }
                curr = root;
            }
            return res;
        }
        
        else{
            sb.append(c);
            int index = 26;
            if(Character.isLetterOrDigit(c)){
                index = c - 'a';
            }
            if(curr.sons[index] == null){
                curr.sons[index] = new TrieNode(curr);
                curr = curr.sons[index];
                return res;
            }
            curr = curr.sons[index];
            return curr.tops();
        }
    }
    
    private void insert(String s){
        TrieNode current = root;
        current.insert(s);
        for(int i = 0; i < s.length(); i++){
            int index = 26;
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                index = c - 'a';
            }
            if(current.sons[index] == null){
                current.sons[index] = new TrieNode(current);
            }
            current = current.sons[index];
            current.insert(s);
        }
    }
    
    
    class TrieNode{
        TrieNode[] sons;
        Set<String> candidates;
        TrieNode parent;
        public TrieNode(TrieNode p){
            sons = new TrieNode[27];
            candidates = new HashSet<>();
            parent = p;
        }

        public void insert(String s){
            candidates.add(s);
        }

        public List<String> tops(){
            List<String> res = new ArrayList<>();
            Queue<String> heap = new PriorityQueue<>(3, (s1, s2) -> map.get(s1) == map.get(s2) ? s2.compareTo(s1) : map.get(s1) - map.get(s2));

            for(String s : candidates){
                heap.offer(s);
                if(heap.size() > 3){
                    heap.poll();
                }
            }
            while(!heap.isEmpty()){
                res.add(0, heap.poll());
            }
            return res;
        }
    }
}
