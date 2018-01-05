package D_Microsoft;
import java.util.*;

public class TT54 {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        while(left <= right && up <= down){
            for(int i = left; i <= right; i++){
                res.add(matrix[up][i]);
            }
            up++;
            
            for(int i = up; i <= down; i++){
                res.add(matrix[i][right]);
            }
            right--;
            
            if(up <= down){
                for(int i = right; i >= left; i--){
                    res.add(matrix[down][i]);
                }
                down--;
            }
            
            if(left <= right){
                for(int i = down; i >= up; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
