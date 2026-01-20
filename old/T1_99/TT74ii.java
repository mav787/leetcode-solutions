package old.T1_99;

public class TT74ii {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(matrix[mid / n][mid % n] < target)
                left = mid;
            else
                right = mid;
        }
        if(matrix[left / n][left % n] == target || matrix[right / n][right % n] == target)
            return true;
        else
            return false;
    }
}
