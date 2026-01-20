package old.T200_299;

public class T208 {
    
    TrieNode root;

    /** Initialize your data structure here. */
    public T208() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null)
            return;
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null)
            return false;
        if(word.length() == 0)
            return root.isEnd;
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curr.sons[index] == null)
                return false;
            curr = curr.sons[index];
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null)
            return false;
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(curr.sons[index] == null)
                return false;
            curr = curr.sons[index];
        }
        return true;
    }
}

class TrieNode{
    TrieNode[] sons;
    boolean isEnd;
    
    TrieNode(){
        sons = new TrieNode[26];
        isEnd = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
