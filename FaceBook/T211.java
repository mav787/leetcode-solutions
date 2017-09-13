package FaceBook;

public class T211 {
	private TrieNode root;

    /** Initialize your data structure here. */
    public T211() {
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
        return backtrack(word, root, 0);
    }
    
    private boolean backtrack(String word, TrieNode root, int index){
        if(root == null) return false;
        if(index == word.length()) return root.isEnd;
        if(word.charAt(index) == '.'){
            // backtrack
            for(int i = 0; i < 26; i++){
                if(backtrack(word, root.sons[i], index + 1)){
                    return true;
                }
            }
            return false;
        }
        else{
            int next = word.charAt(index) - 'a';
            return backtrack(word, root.sons[next], index + 1);
        }
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
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
