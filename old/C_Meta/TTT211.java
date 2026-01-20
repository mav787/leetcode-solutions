package old.C_Meta;

public class TTT211 {
	private TrieNode root;
    /** Initialize your data structure here. */
    public TTT211() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curr.sons[index] == null){
                curr.sons[index] = new TrieNode();
            }
            curr = curr.sons[index];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null) return false;
        return search(word, root, 0);
    }
    
    private boolean search(String word, TrieNode root, int pos){
        if(root == null) return false;
        if(pos == word.length()){
            return root.isEnd;
        }
        
        if(word.charAt(pos) == '.'){
            for(int i = 0; i < root.sons.length; i++){
                if(search(word, root.sons[i], pos + 1)) return true;
            }
            return false;
        }
        
        int index = word.charAt(pos) - 'a';
        return search(word, root.sons[index], pos + 1);
    }
}


class TrieNode{
    private static final int FANOUT = 26;
    TrieNode[] sons;
    boolean isEnd;
    public TrieNode(){
        sons = new TrieNode[FANOUT];
        isEnd = false;
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
