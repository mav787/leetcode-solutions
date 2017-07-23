package T1_99;

public class TT79my {
	public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0)
            return false;
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(board, word, used, 0, i, j))
                    return true;
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, boolean[][] visited, int index, int i, int j){
        if(index == word.length())
            return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index) || visited[i][j])
            return false;
        
        visited[i][j] = true;
        if(backtrack(board, word, visited, index + 1, i + 1, j) 
        || backtrack(board, word, visited, index + 1, i - 1, j) 
        || backtrack(board, word, visited, index + 1, i, j + 1) 
        || backtrack(board, word, visited, index + 1, i, j - 1) 
        ){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
