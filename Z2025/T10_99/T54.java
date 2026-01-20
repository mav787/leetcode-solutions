package Z2025.T10_99;
import java.util.*;

public class T54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }

        int m = matrix.length, n = matrix[0].length;
        int top = 0, down = m - 1;
        int left = 0, right = n - 1;

        while(left <= right && top <= down){

            // left to right
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;

            // top to bottom
            for(int i = top; i <= down; i++){
                res.add(matrix[i][right]);
            }

            right--;

            // right to left
            if(top <= down){
                for(int i = right; i >= left; i--){
                    res.add(matrix[down][i]);
                }
                down--;
            }

            // bottom to top
            if(left <= right){
                for(int i = down; i >= top; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }


        return res;
    }
}
