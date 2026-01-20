package old.G_Salesforce.T1000_9999;
import java.util.*;

public class T2865II {
        /*
        Approach -

        Step 1st - Find nextSmallerLeft(index) & will find what's the left sum if heights[i] is the peak
        Step 2nd - Find nextSmallerRight(index) & will find what's the right sum if heights[i] is the peak
        Step 3rd - Find max
        */
    public long maximumSumOfHeights(int[] heights) {
        long res = 0L;
        int n = heights.length;

        int[] nextSmallLeft = getNextSmallLeft(heights);
        int[] nextSmallRight = getNextSmallRight(heights);

        long[] leftSum = getLeftSum(heights, nextSmallLeft);
        long[] rightSum = getRightSum(heights, nextSmallRight);

        for(int i = 0; i < n; i++){
            res = Math.max(res, leftSum[i] + rightSum[i] - (long)(heights[i]));
        }

        return res;
    }

    private int[] getNextSmallLeft(int[] heights){
        int n = heights.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            int height = heights[i];
            if(stack.isEmpty()){
                res[i] = -1;
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && height <= heights[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = -1;
                    stack.push(i);
                }
                else{
                    res[i] = stack.peek();
                    stack.push(i);
                }
            }
        }

        return res;
    }

    private int[] getNextSmallRight(int[] heights){
        int n = heights.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            int height = heights[i];
            if(stack.isEmpty()){
                res[i] = -1;
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && height <= heights[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = -1;
                    stack.push(i);
                }
                else{
                    res[i] = stack.peek();
                    stack.push(i);
                }
            }
        }

        return res;
    }

    private long[] getLeftSum(int[] heights, int[] nextSmallLeft){
        int n = heights.length;
        long[] leftSum = new long[n];

        leftSum[0] = heights[0];

        for(int i = 1; i < n; i++){
            if(heights[i] > heights[i - 1]){
                leftSum[i] = leftSum[i - 1] + heights[i];
            }
            else{
                int prev = nextSmallLeft[i];
                if(prev == -1){
                    leftSum[i] = (long)heights[i] * (i + 1);
                }
                else{
                    leftSum[i] = (long)heights[i] * (i - prev) + leftSum[prev];
                }
            }
        }
        return leftSum;
    }

    private long[] getRightSum(int[] heights, int[] nextSmallRight){
        int n = heights.length;
        long[] rightSum = new long[n];

        rightSum[n - 1] = heights[n - 1];
        for(int i = n - 2; i >= 0; i--){
            if(heights[i] > heights[i + 1]){
                rightSum[i] = rightSum[i + 1] + heights[i];
            }
            else{
                int prev = nextSmallRight[i];
                if(prev == -1){
                    rightSum[i] = (long)heights[i] * (n - i);
                }
                else{
                    rightSum[i] = (long)heights[i] * (prev - i) + rightSum[prev];
                }
            }
        }
        return rightSum;
    }
}
