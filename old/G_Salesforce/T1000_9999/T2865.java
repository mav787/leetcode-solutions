package old.G_Salesforce.T1000_9999;

public class T2865 {
    public long maximumSumOfHeights(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0L;
        }

        long max = 0;
        for(int i = 0; i < heights.length; i++){
            max = Math.max(max, helper(heights, i));
        }

        return max;
    }

    private long helper(int[] heights, int index){
        long res = 0;
        int max = heights[index];
        for(int i = index - 1; i >= 0; i--){
            max = Math.min(max, heights[i]);
            res += max;
        }

        max = heights[index];
        for(int i = index + 1; i < heights.length; i++){
            max = Math.min(max, heights[i]);
            res += max;
        }

        res += heights[index];
        return res;
    }
}
