package old.T1_99;
import java.util.*;

public class TT36my {
	public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9)
            return false;
        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();
        Set<Character> cellSet = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !rowSet.add(board[i][j]))
                    return false;
                if(board[j][i] != '.' && !colSet.add(board[j][i]))
                    return false;
                if(board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3] != '.'
                    && !cellSet.add(board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3]))
                    return false;
            }
            rowSet.clear();
            colSet.clear();
            cellSet.clear();
        }
        return true;
    }
}
