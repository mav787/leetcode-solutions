package Z2025.T10_99;

public class T73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean setRow = false, setCol = false;

        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                setCol = true;
            }
        }

        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                setRow = true;
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                setRow(matrix, i);
            }
        }

        for(int j = 1; j < n; j++){
            if(matrix[0][j] == 0){
                setCol(matrix, j);
            }
        }

        if(setRow){
            setRow(matrix, 0);
        }
        if(setCol){
            setCol(matrix, 0);
        }

    }

    private void setRow(int[][] matrix, int i){
        for(int j = 0; j < matrix[i].length; j++){
            matrix[i][j] = 0;
        }
    }

    private void setCol(int[][] matrix, int j){
        for(int i = 0; i < matrix.length; i++){
            matrix[i][j] = 0;
        }
    }
}
