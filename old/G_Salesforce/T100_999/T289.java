package old.G_Salesforce.T100_999;

public class T289 {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0] == null){
            return;
        }

        int m = board.length, n = board[0].length;

        // 0: dead to dead
        // 1: live to live
        // 2: live to dead
        // 3: dead to live

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int nei = getNeighbors(board, i, j);
                if(board[i][j] == 0 && nei == 3){
                    board[i][j] = 3;
                }
                else if(board[i][j] == 1){
                    if(nei < 2 || nei > 3){
                        board[i][j] = 2;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] %= 2;
            }
        }
    }


    private int getNeighbors(int[][] board, int x, int y){
        int[] dx = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};

        int res = 0;
        for(int i = 0; i < dx.length; i++){
            int newX = x + dx[i], newY = y + dy[i];
            if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length){
                if(board[newX][newY] == 1 || board[newX][newY] == 2){
                    res++;
                }
            }
        }
        return res;
    }
}
