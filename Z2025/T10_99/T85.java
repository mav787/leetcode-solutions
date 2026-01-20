package Z2025.T10_99;
import java.util.*;

public class T85 {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int m = matrix.length, n = matrix[0].length;

        // histogram
        int[] hist = new int[n];
        for(int i = 0; i < m; i++){
            // get histogram ready
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    hist[j]++;
                }
                else{
                    hist[j] = 0;
                }
            }

            // process histogram
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);

            for(int j = 0; j < n; j++){
                while(stack.peek() != -1 && hist[j] <= hist[stack.peek()]){
                    int height = hist[stack.pop()];
                    res = Math.max(res, height * (j - stack.peek() - 1));
                }
                stack.push(j);
            }

            // process remaining
            while(stack.peek() != -1){
                int height = hist[stack.pop()];
                res = Math.max(res, height * (n - stack.peek() - 1));
            }
        }

        return res;
    }
}
