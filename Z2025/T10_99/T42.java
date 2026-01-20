package Z2025.T10_99;

public class T42 {
    public int trap(int[] height) {
        if(height == null || height.length < 2){
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int res = 0;

        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(height[left] < height[right]){
                res += leftMax - height[left];
                left++;
            }
            else{
                res += rightMax - height[right];
                right--;
            }
        }

        return res;
    }
}
