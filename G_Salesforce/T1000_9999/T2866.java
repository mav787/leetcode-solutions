package G_Salesforce.T1000_9999;
import java.util.*;

public class T2866 {
    class Solution {
        public long maximumSumOfHeights(List<Integer> maxHeights) {

            int n = maxHeights.size();

            // initialize monotonic stack and prefix, suffix arrays
            Stack<Integer> stack = new Stack<>();
            long pre[] = new long[n];
            long suf[] = new long[n];

            //intitialize minimum and maximum values
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int i = 0 ; i < n ; i++){

                //update minimum and maximum values
                min = Math.min(min,maxHeights.get(i));
                max = Math.max(max,maxHeights.get(i));

                if(min == maxHeights.get(i)){
                    pre[i] = (long)(i + 1) * maxHeights.get(i);
                }

                else if(max == maxHeights.get(i)){
                    pre[i] = pre[i - 1] + maxHeights.get(i);
                }

                else{
                    while(!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)){
                        stack.pop();
                    }
                    pre[i] += pre[stack.peek()];
                    pre[i] += (long)maxHeights.get(i) * (i - stack.peek());

                }
                // always pushing the index of the element
                stack.push(i);
            }

            // reset the stack and min , max values
            stack.clear();
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            // iterating from back side and repeating the same as above
            for(int i = n - 1 ; i >= 0 ; i--){

                min = Math.min(min,maxHeights.get(i));
                max = Math.max(max,maxHeights.get(i));

                if(min == maxHeights.get(i)){
                    suf[i] = (long)(n - i) * maxHeights.get(i);
                }

                else if(max == maxHeights.get(i)){
                    suf[i] = suf[i + 1] + maxHeights.get(i);
                }

                else{
                    while(!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)){
                        stack.pop();
                    }
                    suf[i] += suf[stack.peek()];
                    suf[i] += (long)maxHeights.get(i) * (stack.peek() - i);
                }
                stack.push(i);
            }

            long ans = 0;

            //checking for the optimal peak point
            for(int i = 0 ; i < n ; i++){
                long sum = pre[i] + suf[i];
                sum -= maxHeights.get(i); // since maxHeights.get(i) is present in both pre[i] and suf[i]
                ans = Math.max(ans , sum);
            }

            return ans;
        }
    }
}
