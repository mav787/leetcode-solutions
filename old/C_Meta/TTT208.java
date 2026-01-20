package old.C_Meta;

public class TTT208 {

    private TrieNode root;

    /** Initialize your data structure here. */
    public TTT208() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curr.sons[index] == null){
                return false;
            }
            curr = curr.sons[index];
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(curr.sons[index] == null){
                return false;
            }
            curr = curr.sons[index];
        }
        return true;
    }
}

//class TrieNode{
//    private static final int FANOUT = 26;
//    TrieNode[] sons;
//    boolean isEnd;
//    public TrieNode(){
//        sons = new TrieNode[FANOUT];
//        isEnd = false;
//    }
//}
