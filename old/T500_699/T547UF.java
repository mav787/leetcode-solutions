package old.T500_699;
import java.util.*;

public class T547UF {
	public int findCircleNum(int[][] M) {
        int[] roots = new int[M.length];
        Arrays.fill(roots, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                	
                	// find
                	int xset = find(roots, i);
                	int yset = find(roots, j);
                	
                	// union
                	if(xset != yset){
                		roots[xset] = yset;
                	}
                }
            }
        }
        int count = 0;
        for (int i = 0; i < roots.length; i++) {
            if (roots[i] == -1)
                count++;
        }
        return count;
    }
	
	int find(int roots[], int i) {
        if (roots[i] == -1)
            return i;
        return find(roots, roots[i]);
    }
}
