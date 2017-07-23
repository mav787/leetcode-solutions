package T1_99;

public class TT34 {
	public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int firstleft = 0, lastleft = 0, firstright = nums.length - 1, lastright = nums.length - 1;
        while(firstleft + 1 < firstright || lastleft + 1 < lastright){
            int firstmid = firstleft + (firstright - firstleft) / 2;
            int lastmid = lastleft + (lastright - lastleft) / 2;
            // first:
            if(nums[firstmid] < target)
                firstleft = firstmid;
            else
                firstright = firstmid;
            
            
            // last:
            if(nums[lastmid] > target)
                lastright = lastmid;
            else
                lastleft = lastmid;
        }
        
        int[] res = new int[2];
        if(nums[firstleft] == target)
            res[0] = firstleft;
        else if(nums[firstright] == target)
            res[0] = firstright;
        else
            res[0] = -1;
        
        
        if(nums[lastright] == target)
            res[1] = lastright;
        else if(nums[lastleft] == target)
            res[1] = lastleft;
        else
            res[1] = -1;
            
        return res;
    }
}
