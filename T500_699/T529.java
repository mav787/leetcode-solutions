package T500_699;

public class T529 {
	public char[][] updateBoard(char[][] board, int[] click) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return board;
        int m = board.length, n = board[0].length;
        int x = click[0], y = click[1];
        if(x >= m || y >= n || x < 0 || y < 0)
            return board;
        switch (board[x][y]){
            case 'M':
                board[x][y] = 'X';
                return board;
            case 'E':
                int count = countNeighbor(board, x, y, m, n);
                if (count == 0){
                    board[x][y] = 'B';
                    for(int i = -1; i <= 1; i++){
                        for(int j = -1; j <= 1; j++){
                            if(i == 0 && j == 0)
                                continue;
                            int[] coord = new int[]{x + i, y + j};
                            updateBoard(board, coord);
                        }
                    }
                }
                else{
                    board[x][y] = (char)('0' + count);
                }
                break;
            default:
                break;
        }
        return board;
    }
    
    private int countNeighbor(char[][]board, int x, int y, int m, int n){
        if (x < 0 || y < 0 || x >= m || y >= n)
            return 0;
        // 8  neighbors...
        int count = 0;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                int newx = x + i, newy = y + j;
                if(i == 0 && j == 0)
                    continue;
                if(newx < 0 || newy < 0 || newx >= m || newy >= n)
                    continue;
                if(board[newx][newy] == 'M')
                    count++;
            }
        }
        return count;
    }
}
