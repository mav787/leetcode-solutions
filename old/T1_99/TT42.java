package old.T1_99;

public class TT42 {
	public int trap(int[] height) {
        if(height == null || height.length < 2) return 0;
        int left = height[0], right = height[height.length - 1];
        int i = 0, j = height.length - 1;
        int res = 0;
        
        while(i <= j){
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
