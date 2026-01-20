package old.T1_99;
import java.util.*;
public class TT85ii {
	public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int[] tops = new int[n], lefts = new int[n], rights = new int[n];
        Arrays.fill(tops, 0);
        Arrays.fill(lefts, n);
        Arrays.fill(rights, n);
        int max = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    tops[j] += 1;
                } else {
                    tops[j] = 0;
                }
            }
            
            int l = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    lefts[j] = Math.min(lefts[j], ++l);
                } else {
                    lefts[j] = n;
                    l = 0;
                }
            }
            
            int r = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    rights[j] = Math.min(rights[j], ++r);
                } else {
                    rights[j] = n;
                    r = 0;
                }
            }
            
            for (int j = 0; j < n; j++) {
                max = Math.max(max, (lefts[j] + rights[j] - 1) * tops[j]);
            }
        }
        
        return max;
    }
}
