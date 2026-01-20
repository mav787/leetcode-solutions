package old.T1_99;
import java.util.*;

public class TT36 {
	public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            Set<Character> rows = new HashSet<Character>();
            Set<Character> columns = new HashSet<Character>();
            Set<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i] != '.' && !columns.add(board[j][i]))
                    return false;
                
                int upleftrow = 3 * (i / 3);
                int upleftcol = 3 * (i % 3);
                if(board[upleftrow + j / 3][upleftcol + j % 3] != '.' && !cube.add(board[upleftrow + j / 3][upleftcol + j % 3]))
                    return false;
            }
        }
        return true;
    }
}
