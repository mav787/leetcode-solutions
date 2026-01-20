package old.T300_499;

public class T361 {
	public int maxKilledEnemies(char[][] grid) {
        int rowNum = grid.length;
        if (rowNum == 0) return 0;
        int colNum = grid[0].length;

        int[][] fromBottom = new int[rowNum][colNum];
        int[][] fromRight = new int[rowNum][colNum];

        for (int i = rowNum - 1; i >= 0; i--) {
            for (int j = colNum - 1; j >= 0; j--) {
                int enemy = grid[i][j] == 'E' ? 1 : 0;
                if (grid[i][j] != 'W') {
                    fromBottom[i][j] = (i == rowNum - 1) ? enemy : fromBottom[i + 1][j] + enemy;
                    fromRight[i][j] = (j == colNum - 1) ? enemy : fromRight[i][j + 1] + enemy;
                }
                else {
                    fromBottom[i][j] = 0;
                    fromRight[i][j] = 0;
                }
            }
        }

        int[] fromTop = new int[colNum];
        int[] fromLeft = new int[rowNum];
        int max = 0;

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (grid[i][j] != '0') {
                    fromTop[j] = grid[i][j] == 'W' ? 0 : fromTop[j] + 1;
                    fromLeft[i] = grid[i][j] == 'W' ? 0 : fromLeft[i] + 1;
                }
                else {
                    int num = fromTop[j] + fromLeft[i] + fromBottom[i][j] + fromRight[i][j];
                    max = Math.max(num, max);
                }
            }
        }
        return max;
    }
}
