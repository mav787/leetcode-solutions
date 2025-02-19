package G_Salesforce.T1000_9999;
import java.util.*;

public class T1051 {
    public int heightChecker(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }

        int[] sorted = new int[heights.length];
        for(int i = 0; i < heights.length; i++){
            sorted[i] = heights[i];
        }

        Arrays.sort(sorted);

        int res = 0;
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != sorted[i]){
                res++;
            }
        }

        return res;
    }
}
