package Z2025.T100_999;

import java.util.*;

public class T348 {
    class TicTacToe {
        int[][] board;
        int n;

        public TicTacToe(int n) {
            board = new int[n][n];
            this.n = n;
        }

        public int move(int row, int col, int player) {
            board[row][col] = player;


            int rowCount = 0, colCount = 0;
            int diag1Count = 0, diag2Count = 0;

            for(int i = 0; i < n; i++){
                if(board[row][i] == player){
                    rowCount++;
                }
                if(board[i][col] == player){
                    colCount++;
                }

                if(board[i][i] == player){
                    diag1Count++;
                }
                if(board[i][n - 1 - i] == player){
                    diag2Count++;
                }
            }

            if(rowCount == n || colCount == n || diag1Count == n || diag2Count == n){
                return player;
            }

            return 0;
        }
    }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

}
