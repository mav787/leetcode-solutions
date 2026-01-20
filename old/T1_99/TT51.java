package old.T1_99;
import java.util.*;

public class TT51 {
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n <= 0)
            return res;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        backtrack(res, board, 0);
        return res;
    }
    
    private void backtrack(List<List<String>> res, char[][] board, int colIndex){
        if(colIndex == board.length){
            List<String> newBoard = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                newBoard.add(String.valueOf(board[i]));
            }
            res.add(newBoard);
            return;
        }
        
        for(int i = 0; i < board.length; i++){
            if(isValid(board, i, colIndex)){
                board[i][colIndex] = 'Q';
                backtrack(res, board, colIndex + 1);
                board[i][colIndex] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] board, int i, int j){
        int len = board.length;
        if(board[i][j] != '.')
            return false;
        // check directions
        for(int m = 0; m < len; m++){
            if(board[i][m] == 'Q' || board[m][j] == 'Q')
                return false;
            int p = m - i + j;
            if(0 <= p && p < len && board[m][p] == 'Q')
                return false;
            int n = i + j - m;
            if(0 <= n && n < len && board[m][n] == 'Q')
                return false;
        }
        return true;
    }
}
