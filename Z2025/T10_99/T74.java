package Z2025.T10_99;

public class T74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / n][mid % n];
            if(midVal == target){
                return true;
            }
            else if(midVal < target){
                left = mid;
            }
            else{
                right = mid;
            }
        }

        int leftVal = matrix[left / n][left % n];
        int rightVal = matrix[right / n][right % n];
        return leftVal == target || rightVal == target;
    }
}
