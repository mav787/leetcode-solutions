package old.T500_699;
import java.util.*;

public class T646 {
	public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0)
            return 0;
        Arrays.sort(pairs, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        
        int res = 1;
        int j = 0;
        for(int i = 1; i < pairs.length; i++){
            if(pairs[j][1] < pairs[i][0]){
                res++;
                j = i;
            }
        }
        return res;
    }
}
