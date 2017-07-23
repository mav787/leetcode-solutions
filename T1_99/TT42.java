package T1_99;

public class TT42 {
	public int trap(int[] heights){
		if(heights == null || heights.length < 3)
            return 0;
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        int leftmax = 0;
        int rightmax = 0;
        while(left <= right){
            leftmax = Math.max(leftmax, heights[left]);
            rightmax = Math.max(rightmax, heights[right]);
            if(leftmax < rightmax){
                max += (leftmax - heights[left]); // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                left++;
            }
            else{
                max += (rightmax - heights[right]);
                right--;
            }
        }
        return max;
    }
}
