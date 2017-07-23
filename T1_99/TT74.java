package T1_99;

public class TT74 {
	public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = searchRow(matrix, target);
        if (row == -1)
            return false;
        return searchLine(matrix, row, target);
    }
    
    private int searchRow(int[][] matrix, int target){
        int start = 0, end = matrix.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] < target)
                start = mid;
            else if (matrix[mid][0] == target)
                return mid;
            else
                end = mid;
        }
        if (matrix[end][0] <= target)
            return end;
        else if (matrix[start][0] <= target)
            return start;
        else
            return -1;
    }
    
    private boolean searchLine(int[][] matrix, int row, int target){
        int[] line = matrix[row];
        int start = 0, end = line.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(line[mid] < target)
                start = mid;
            else if(line[mid] == target)
                return true;
            else
                end = mid;
        }
        
        if(line[start] == target || line[end] == target)
            return true;
        else
            return false;
    }
}
