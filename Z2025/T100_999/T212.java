package Z2025.T100_999;
import java.util.*;

public class T212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0 || words == null){
            return res;
        }

        TrieNode root = words2Trie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                List<String> list = new ArrayList<>();
                search(list, board, i, j, root, new StringBuilder());
                res.addAll(list);
            }
        }
        return res;
    }

    private void search(List<String> list, char[][] board, int i, int j, TrieNode root, StringBuilder sb){
        if(root == null){
            return;
        }
        if(root.isWord){
            root.isWord = false;
            list.add(sb.toString());
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '?'){
            return;
        }

        int len = sb.length();
        char c = board[i][j];

        TrieNode child = root.children[c - 'a'];
        sb.append(c);
        board[i][j] = '?';

        search(list, board, i - 1, j, child, sb);
        search(list, board, i + 1, j, child, sb);
        search(list, board, i, j - 1, child, sb);
        search(list, board, i, j + 1, child, sb);

        board[i][j] = c;
        sb.setLength(len);
    }

    // words2Trie
    private TrieNode words2Trie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
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
        return root;
    }

    static class TrieNode{
        TrieNode[] children;
        boolean isWord;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
}
