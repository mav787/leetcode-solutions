package C_Meta.T1000_9999;
import java.util.*;

public class T1762 {
    public int[] findBuildings(int[] heights) {
        // linear scan from right to left
        // maintain a max
        // compare the max with the current item
        //  if curr == max
        //      -> add to result
        //  else
        //      -> do nothing
        //  output indices in asc order


        List<Integer> list = new ArrayList<>();
        if(heights == null || heights.length == 0){
            return new int[0];
        }

        int max = 0;
        for(int i = heights.length - 1; i >=0; i--){
            if(heights[i] > max){
                list.add(i);
                max = heights[i];
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(list.size() - i - 1);
        }
        return res;
    }
}
