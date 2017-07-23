package T200_299;

public class T240 {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;
        while(i >= 0 && j < n){
            if(target == matrix[i][j])
                return true;
            else if(target > matrix[i][j])
                j++;
            else
                i--;
        }
        return false;
    }
}
