package T1_99;

public class TT79 {
	public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(exist(board, word, i, j, used, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, String word, int i, int j, boolean[][] used, int index){
        if(index == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || used[i][j] || board[i][j] != word.charAt(index))
            return false;
        used[i][j] = true;
        if(     exist(board, word, i - 1, j, used, index + 1) 
          ||    exist(board, word, i + 1, j, used, index + 1)
          ||    exist(board, word, i, j - 1, used, index + 1)
          ||    exist(board, word, i, j + 1, used, index + 1)) return true;
        used[i][j] = false;
        return false;
    }
}
