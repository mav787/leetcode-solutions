package FaceBook;

public class TTT348 {
	private int[] rowCount;
    private int[] colCount;
    private int diag1, diag2;
    /** Initialize your data structure here. */
    public TTT348(int n) {
        if(n <= 0) return;
        rowCount = new int[n];
        colCount = new int[n];
        diag1 = 0;
        diag2 = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int sign = player == 1 ? 1 : -1;
        int len = rowCount.length;
        rowCount[row] += sign * 1;
        colCount[col] += sign * 1;
        
        if(row == col){
            diag1 += sign * 1;
        }
        if(row + col == len - 1){
            diag2 += sign * 1;
        }
        if(rowCount[row] == len || colCount[col] == len || diag1 == len || diag2 == len){
            return 1;
        }
        if(rowCount[row] == -len || colCount[col] == -len || diag1 == -len || diag2 == -len){
            return 2;
        }
        return 0;
    }
}
