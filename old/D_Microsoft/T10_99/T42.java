package old.D_Microsoft.T10_99;

public class T42 {
    public int trap(int[] height) {
        if(height == null || height.length < 3) return 0;
        int i = 0, j = height.length - 1;

        // get rid of invalid terminals
        // while(i < j && height[i] < height[i + 1]) i++;
        // while(i < j && height[j] < height[j - 1]) j--;

        int res = 0;
        int left = height[i], right = height[j];
        while(i < j){
            left = Math.max(left, height[i]);
            right = Math.max(right, height[j]);

            if(left < right){
                res += left - height[i];
                i++;
            }
            else{
                res += right - height[j];
                j--;
            }
        }
        return res;
    }
}
