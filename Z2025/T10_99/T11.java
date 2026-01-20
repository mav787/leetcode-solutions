package Z2025.T10_99;

public class T11 {
    public int maxArea(int[] height) {
        int res = 0;
        if(height == null || height.length < 2){
            return 0;
        }

        int left = 0, right = height.length - 1;
        while(left <= right){
            if(height[left] <= height[right]){
                res = Math.max(res, height[left] * (right - left));
                left++;
            }
            else{
                res = Math.max(res, height[right] * (right - left));
                right--;
            }
        }

        return res;
    }
}
