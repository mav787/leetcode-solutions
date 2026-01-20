package Z2025.T10_99;

public class T79 {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0){
            return false;
        }
        if(word == null || word.length() == 0){
            return true;
        }

        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(helper(board, i, j, word, 0, used)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int i, int j, String word, int index, boolean[][] used){
        if(index == word.length()){
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || used[i][j]){
            return false;
        }

        if(board[i][j] != word.charAt(index)){
            return false;
        }

        used[i][j] = true;

        boolean result = helper(board, i - 1, j, word, index + 1, used)
                || helper(board, i + 1, j, word, index + 1, used)
                || helper(board, i, j - 1, word, index + 1, used)
                || helper(board, i, j + 1, word, index + 1, used);

        used[i][j] = false;
        return result;
    }
}
