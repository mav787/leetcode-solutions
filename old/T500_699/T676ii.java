package old.T500_699;

public class T676ii {
	
	private TrieNode root;

    /** Initialize your data structure here. */
    public T676ii() {
        root = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        if(dict == null) return;
        for(String s : dict){
            add(s);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(word == null) return false;
        char[] ca = word.toCharArray();
        for(int i = 0; i < ca.length; i++){
            char ori = ca[i];
            for(char c = 'a'; c <= 'z'; c++){
                if(c == ori) continue;
                ca[i] = c;
                if(normalSearch(String.valueOf(ca))) return true;
                ca[i] = ori;
            }
        }
        return false;
    }
    
    private boolean normalSearch(String s){
    	TrieNode curr = root;
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(curr.sons[index] == null) return false;
            curr = curr.sons[index];
        }
        return curr.isEnd;
    }
    
    private void add(String s){
        if(s == null) return ;
        TrieNode curr = root;
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(curr.sons[index] == null){
                curr.sons[index] = new TrieNode();
            }
            curr = curr.sons[index];
        }
        curr.isEnd = true;
    }
}


class TrieNode{
    boolean isEnd;
    TrieNode[] sons;
    public TrieNode(){
        sons = new TrieNode[26];
    }
}
