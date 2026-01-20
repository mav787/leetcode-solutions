package Z2025.T10_99;
import java.util.*;

public class T84 {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }

        Stack<Integer> minLefts = new Stack<>();
        Stack<Integer> minRights = new Stack<>();

        int[] leftMap = new int[heights.length];
        int[] rightMap = new int[heights.length];

        for(int i = 0; i < heights.length; i++){
            while(!minLefts.isEmpty() && heights[i] <= heights[minLefts.peek()]){
                minLefts.pop();
            }
            int left = minLefts.isEmpty() ? -1 : minLefts.peek();
            leftMap[i] = left;
            minLefts.push(i);
        }

        for(int i = heights.length - 1; i >= 0; i--){
            while(!minRights.isEmpty() && heights[i] <= heights[minRights.peek()]){
                minRights.pop();
            }

            int right = minRights.isEmpty() ? heights.length : minRights.peek();
            rightMap[i] = right;
            minRights.push(i);
        }

        int res = 0;

        for(int i = 0; i < heights.length; i++){
            res = Math.max(res, heights[i] * (rightMap[i] - leftMap[i] - 1));
        }

        return res;
    }
}
