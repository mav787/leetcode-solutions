package T500_699;
import java.util.*;

public class T677 {
	LongTrieNode root;
    Map<String, Integer> map;

    /** Initialize your data structure here. */
    public T677() {
        root = new LongTrieNode();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        if(map.containsKey(key)){
            int oldVal = map.get(key);
            long diff = (long)val - (long)oldVal;
            updateSum(key, diff);
        }
        else{
            updateSum(key, (long)val);
        }
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        // traverse and return trienode
        // edge test
        LongTrieNode curr = root;
        if(prefix == null) return 0;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(curr.sons[index] == null){
                return 0;
            }
            curr = curr.sons[index];
        }
        return (int)curr.sum;
    }
    
    private void updateSum(String key, long val){
        LongTrieNode curr = root;
        curr.sum += val;
        for(int i = 0; i < key.length(); i++){
            int index = key.charAt(i) - 'a';
            if(curr.sons[index] == null){
                curr.sons[index] = new LongTrieNode();
            }
            curr = curr.sons[index];
            curr.sum += val;
        }
    }
    
}

class LongTrieNode{
    LongTrieNode[] sons;
    long sum;
    public LongTrieNode(){
        sons = new LongTrieNode[26];
        sum = 0;
    }
}

