package G_Salesforce.T1000_9999;
import java.util.*;

public class T2866My {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        if(maxHeights == null || maxHeights.size() == 0){
            return 0L;
        }

        int n = maxHeights.size();

        // 1. get monotonic stacks
        int[] nextSmallLeft = getNextSmallLeft(maxHeights);
        int[] nextSmallRight = getNextSmallRight(maxHeights);


        // 2. get left sum : sum = 0 ~ i
        long[] leftSum = new long[n];
        leftSum[0] = maxHeights.get(0);
        for(int i = 1; i < n; i++){
            if(maxHeights.get(i) >= maxHeights.get(i - 1)){
                leftSum[i] = leftSum[i - 1] + maxHeights.get(i);
            }
            else{
                int prev = nextSmallLeft[i];
                if(prev != -1){
                    leftSum[i] = (long)maxHeights.get(i) * (i - prev) + leftSum[prev];
                }
                else{
                    leftSum[i] = (long)maxHeights.get(i) * (i + 1);
                }
            }
        }

        // 3. get right sum : sum = i ~ n - 1
        long[] rightSum = new long[n];
        rightSum[n - 1] = maxHeights.get(n - 1);
        for(int i = n - 2; i >= 0; i--){
            if(maxHeights.get(i) >= maxHeights.get(i + 1)){
                rightSum[i] = rightSum[i + 1] + maxHeights.get(i);
            }
            else{
                int prev = nextSmallRight[i];
                if(prev != -1){
                    rightSum[i] = (long)maxHeights.get(i) * (prev - i) + rightSum[prev];
                }
                else{
                    rightSum[i] = (long)maxHeights.get(i) * (n - i);
                }
            }
        }

        // 4. get max
        long res = 0L;
        for(int i = 0; i < n; i++){
            long sum = leftSum[i] + rightSum[i] - maxHeights.get(i);
            res = Math.max(res, sum);
        }

        return res;
    }


    private int[] getNextSmallLeft(List<Integer> heights){
        int n = heights.size();
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            int height = heights.get(i);
            if(stack.isEmpty()){
                res[i] = -1;
                stack.push(i);
            }
            else{
                if(height > heights.get(stack.peek())){
                    res[i] = stack.peek();
                    stack.push(i);
                }
                else{
                    while(!stack.isEmpty() && heights.get(stack.peek()) >= height){
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
        }

        return res;
    }

    private int[] getNextSmallRight(List<Integer> heights){
        int n = heights.size();
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1; i >= 0; i--){
            int height = heights.get(i);
            if(stack.isEmpty()){
                res[i] = -1;
                stack.push(i);
            }
            else{
                if(height > heights.get(stack.peek())){
                    res[i] = stack.peek();
                    stack.push(i);
                }
                else{
                    while(!stack.isEmpty() && height <= heights.get(stack.peek())){
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
        }
        return res;
    }
}
