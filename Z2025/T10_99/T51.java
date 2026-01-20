package Z2025.T10_99;
import java.util.*;

public class T51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        helper(board, 0, res);
        return res;
    }

    private void helper(char[][] board, int row, List<List<String>> res){
        if(row == board.length){
            List<String> solution = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                solution.add(String.valueOf(board[i]));
            }
            res.add(solution);
            return;
        }

        // filling row-th row now
        for(int i = 0; i < board[row].length; i++){
            // 1. validate
            char c = board[row][i];
            boolean valid = true;
            for(int j = 0; j < row; j++){
                if(board[j][i] == 'Q'){
                    valid = false;
                    break;
                }
                if(row - j - 1 >= 0 && i - j - 1 >= 0 && board[row - j - 1][i - j - 1] == 'Q'){
                    valid = false;
                    break;
                }
                if(row - j - 1 >= 0 && i + j + 1 < board.length && board[row - j - 1][i + j + 1] == 'Q'){
                    valid = false;
                    break;
                }
            }
            if(!valid){
                continue;
            }

            // 2. flip to 'Q'
            board[row][i] = 'Q';

            // 3. call next row
            helper(board, row + 1, res);

            // 4. flip back
            board[row][i] = '.';
        }
    }
}
