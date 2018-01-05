package T200_299;
import java.util.*;

public class T212 {
	public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }
    
    public void dfs(char[][] board, int i, int j, TrieNode curr, List<String> res) {
        char c = board[i][j];
        if (c == '#' || curr.sons[c - 'a'] == null) 
        	return;
        curr = curr.sons[c - 'a'];
        if (curr.word != null) {   // found one
            res.add(curr.word);
            curr.word = null;     // de-duplicate
        }
    
        board[i][j] = '#';
        if (i > 0) 
        	dfs(board, i - 1, j ,curr, res); 
        if (j > 0) 
        	dfs(board, i, j - 1, curr, res);
        if (i < board.length - 1) 
        	dfs(board, i + 1, j, curr, res); 
        if (j < board[0].length - 1) 
        	dfs(board, i, j + 1, curr, res); 
        
        board[i][j] = c;
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String s : words) {
            TrieNode curr = root;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (curr.sons[index] == null) {
                	curr.sons[index] = new TrieNode();
                }	
                curr = curr.sons[index];
           }
           curr.word = s;	// isEnd
        }
        return root;
    }
    
	class TrieNode {
	    TrieNode[] sons;
	    String word;
	    public TrieNode(){
	    	sons = new TrieNode[26];
	    }
	}
}
