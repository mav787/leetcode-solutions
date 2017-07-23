package T1_99;

public class TT11 {
	public int maxArea(int[] height) {
        if(height == null || height.length < 2)
            return 0;
        int max = 0;
        int left = 0, right = height.length - 1;
        while(left < right){
            if(height[left] < height[right]){
                max = Math.max(max, height[left] * (right - left));
                left++;
            }else{
                max = Math.max(max, height[right] * (right - left));
                right--;
            }
        }
        return max;
    }
}
