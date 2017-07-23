package T1_99;
import java.util.*;

public class TT85 {
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) 
        	return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n];
        for(int i = 0; i < n; i++){
            if(matrix[0][i] == '1') 
            	height[i] = 1;
        }
        int result = largestInLine(height);
        for(int i = 1; i < m; i++){
            resetHeight(matrix, height, i);
            result = Math.max(result, largestInLine(height));
        }
        return result;
    }
    
    private void resetHeight(char[][] matrix, int[] height, int idx){
        for(int i = 0; i < matrix[0].length; i ++){
            if(matrix[idx][i] == '1') 
            	height[i] += 1;
            else 
            	height[i] = 0;
        }
    }    
    
    public int largestInLine(int[] height) {
        if(height == null || height.length == 0) 
        	return 0;
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(stack.isEmpty() || h >= height[stack.peek()]){
            	stack.push(i);
            }else{
                int tp = stack.pop();
                maxArea = Math.max(maxArea, height[tp] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
