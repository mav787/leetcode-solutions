package Z2025.T100_999;

public class T130 {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            flip(board, i, 0, m, n, 'O', '?');
            flip(board, i, n - 1, m, n, 'O', '?');
        }

        for(int j = 0; j < n; j++){
            flip(board, 0, j, m, n, 'O', '?');
            flip(board, m - 1, j, m, n, 'O', '?');
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                flip(board, i, j, m, n, 'O', 'X');
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '?'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void flip(char[][] board, int i, int j, int m, int n, char cin, char cout){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return;
        }
        if(board[i][j] != cin){
            return;
        }

        board[i][j] = cout;
        flip(board, i - 1, j, m, n, cin, cout);
        flip(board, i + 1, j, m, n, cin, cout);
        flip(board, i, j - 1, m, n, cin, cout);
        flip(board, i, j + 1, m, n, cin, cout);
    }
}
