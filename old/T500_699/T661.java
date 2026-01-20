package old.T500_699;

public class T661 {
	public int[][] imageSmoother(int[][] M) {
        if(M == null || M.length == 0 || M[0] == null || M[0].length == 0) return new int[0][0];
        int m = M.length, n = M[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                write(res, i, j, M);
            }
        }
        return res;
    }
    
    private void write(int[][] res, int x, int y, int[][] image){
        int count = 0;
        int sum = 0;
        for(int i = x - 1; i <= x + 1; i++){
            if(i < 0 || i >= image.length) continue;
            for(int j = y - 1; j <= y + 1; j++){
                if(j < 0 || j >= image[i].length) continue;
                //if(i == x && j == y) continue;
                sum += image[i][j];
                count++;
            }
        }
        res[x][y] = sum / count;
    }
}
