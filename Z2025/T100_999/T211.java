package Z2025.T100_999;

public class T211 {
    TrieNode root;

    public T211() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode root){
        if(root == null){
            return false;
        }

        if(index == word.length()){
            return root.isWord;
        }

        char c = word.charAt(index);
        if(c == '.'){
            for(int i = 0; i < 26; i++){
                if(search(word, index + 1, root.children[i])){
                    return true;
                }
            }
        }
        else{
            return search(word, index + 1, root.children[c - 'a']);
        }
        return false;
    }

    static class TrieNode{
        TrieNode[] children;
        boolean isWord;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        }

        public TrieNode(boolean isWord){
            this.children = new TrieNode[26];
            this.isWord = isWord;
        }
    }
}
