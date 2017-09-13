package FaceBook;

public class TT80ii {
	public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        if(nums.length < 3) return nums.length;
        // nums.length >= 3
        
        int curr = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] == nums[curr - 2]) continue;
            nums[curr] = nums[i];
            curr++;
        }
        return curr;
    }
}
