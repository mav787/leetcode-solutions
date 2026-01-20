package old.C_Meta;

public class TT85dp {
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;

        int[][] left = new int[m + 1][n + 1];
        int[][] top = new int[m + 1][n + 1];
        int res = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    left[i][j] = left[i][j - 1] + 1;
                    top[i][j] = top[i - 1][j] + 1;
                    res = Math.max(res, helper(left, top, i, j));
                }
            }
        }

        return res;
    }

    private int helper(int[][] left, int[][] top, int i, int j) {
        int maxArea = 0;

        int move = 0;
        int minH = top[i][j];
        while (move < left[i][j]) {
            minH = Math.min(minH, top[i][j - move]);	//
            maxArea = Math.max(maxArea, (move + 1) * minH);
            move++;
        }

        return maxArea;
    }
}
