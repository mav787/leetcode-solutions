package old.T300_499;

public class T311 {
	public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null)
            return null;
        int m = A.length, n = A[0].length, r = B[0].length;
        int[][] C = new int[m][r];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // order tricks..
                if(A[i][j] != 0){
                    for(int k = 0; k < r; k++){
                        // prune in advance
                        if(B[j][k] != 0){
                            C[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }
            }
        }
        return C;
    }
}
