package T200_299;

public class T289 {
	private int[][] dir = {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
    // 0 : dead to dead
    // 1 : live to live
    // 2 : live to dead
    // 3 : dead to live
    public void gameOfLife(int[][] board) {
        if(board == null)
            return;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int live = 0;
                for(int[] d : dir){
                    if(d[0] + i < 0 || d[0] + i >= m || d[1] + j < 0 || d[1] + j >= n)
                        continue;
                    if(board[d[0] + i][d[1] + j] == 1 || board[d[0] + i][d[1] + j] == 2)    // was alive
                        live++;
                }
                if(board[i][j] == 0 && live == 3)
                    board[i][j] = 3;
                if(board[i][j] == 1 && (live < 2 || live > 3))
                    board[i][j] = 2;
            }
        }
        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] %=  2;
            }
        }
    }
}
