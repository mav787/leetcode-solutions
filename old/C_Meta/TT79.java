package old.C_Meta;

public class TT79 {
	public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0 || word == null || word.length() == 0)
            return false;
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(board, word, used, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, boolean[][] used, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        if(i < 0 || i >= used.length || j < 0 || j >= used[i].length) return false;
        if(used[i][j] || word.charAt(index) != board[i][j]) return false;
        
        used[i][j] = true;
        if(backtrack(board, word, used, i - 1, j    , index + 1)) return true;
        if(backtrack(board, word, used, i + 1, j    , index + 1)) return true;
        if(backtrack(board, word, used, i    , j - 1, index + 1)) return true;
        if(backtrack(board, word, used, i    , j + 1, index + 1)) return true;
        used[i][j] = false;
        
        return false;
    }
}
