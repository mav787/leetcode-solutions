package FaceBook;

public class TTT311 {
	public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null)
            return null;
        int m = A.length, n = A[0].length, r = B[0].length;
        int[][] C = new int[m][r];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(A[i][j] != 0){
                    for(int k = 0; k < r; k++){
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
