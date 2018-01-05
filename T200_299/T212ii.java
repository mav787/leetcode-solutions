package T200_299;
import java.util.*;
public class T212ii {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0 || words == null) return res;
        TrieNode root = new TrieNode();
        for(String s : words){
            add(root, s);
        }
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                backtrack(res, board, i, j, used, root, new StringBuilder());
            }
        }
        return res;
    }
    
    private void backtrack(List<String> res, char[][] board, int i, int j, boolean[][] used, TrieNode root, StringBuilder sb){
        if(root == null) return;
        
        if(root.isEnd){
            res.add(sb.toString());
            root.isEnd = false; 		// de-dup
        }
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || used[i][j]) return;
        
        char c = board[i][j];
        used[i][j] = true;
        
        int len = sb.length();
        sb.append(c);
        
        int index = c - 'a';
        backtrack(res, board, i - 1, j, used, root.sons[index], sb);
        backtrack(res, board, i + 1, j, used, root.sons[index], sb);
        backtrack(res, board, i, j - 1, used, root.sons[index], sb);
        backtrack(res, board, i, j + 1, used, root.sons[index], sb);
        
        sb.setLength(len);
        used[i][j] = false;
    }
    
    private void add(TrieNode root, String s){
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
    
    class TrieNode{
        TrieNode[] sons;
        boolean isEnd;
        public TrieNode(){
            sons = new TrieNode[26];
        }
    }
}


