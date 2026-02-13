package Z2025.T100_999;

public class T240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;

        // diagonal search, start from topright
        int i = 0, j = n - 1;

        while(i < m && j >= 0){
            if(matrix[i][j] == target) {
                return true;
            }
            // Largest item in row is still smaller than target. Eliminate row.
            else if(matrix[i][j] < target) {
                i++;
            }
            // Smallest item in column is still larger than target. Eliminate column.
            else {
                j--;
            }
        }
        return false;
    }
}
