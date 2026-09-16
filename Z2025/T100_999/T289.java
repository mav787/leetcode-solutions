package Z2025.T100_999;

import java.util.*;

public class T289 {
    public void gameOfLife(int[][] board) {
        // 0 means dead, 1 means live
        // 2 means from 0 to 1, 3 means from 1 to 0

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                int count = getCount(board, i, j);
                if(count < 2){
                    if(board[i][j] == 1){
                        board[i][j] = 3;
                    }
                }
                else if(count == 2 || count == 3){
                    if(count == 3 && board[i][j] == 0){
                        board[i][j] = 2;
                    }
                }
                else{
                    if(board[i][j] == 1){
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                else if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
    }

    private int getCount(int[][] board, int x, int y){
        int res = 0;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                if(x + i < 0 || x + i >= board.length){
                    continue;
                }
                if(y + j < 0 || y + j >= board[x].length){
                    continue;
                }

                if(board[x + i][y + j] == 1 || board[x + i][y + j] == 3){
                    res++;
                }
            }
        }
        return res;
    }

}
