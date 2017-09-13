package T500_699;
import java.util.*;

public class T676 {
	Set<String> set;
    /** Initialize your data structure here. */
    public T676() {
        set = new HashSet<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        if(dict == null) return ;
        for(String s : dict){
            set.add(s);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for(String s : set){
            if(computeDistance(word, s) == 1) return true;
        }
        return false;
    }
    
    private int computeDistance(String a, String b){
        if(a.length() != b.length()) return 0;
        int dist = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                dist++;
            }
            if(dist > 1){
                return 2;
            }
        }
        return dist;
    }
}
