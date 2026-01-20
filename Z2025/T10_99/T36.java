package Z2025.T10_99;
import java.util.*;

public class T36 {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> cellMap = new HashMap<>();

        for(int i = 0; i < 9; i++){
            rowMap.put(i, new HashSet<>());
            colMap.put(i, new HashSet<>());
            cellMap.put(i, new HashSet<>());
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char c = board[i][j];
                if(c == '.'){
                    continue;
                }
                if(!rowMap.get(i).add(c)){
                    return false;
                }
                if(!colMap.get(j).add(c)){
                    return false;
                }
                if(!cellMap.get(i / 3 * 3 + j / 3).add(c)){
                    return false;
                }
            }
        }

        return true;
    }
}
