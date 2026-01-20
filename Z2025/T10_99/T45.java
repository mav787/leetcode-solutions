package Z2025.T10_99;

public class T45 {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }

        int res = 0;
        int prev = 0;
        int farthest = 0;

        for(int i = 0; i < nums.length; i++){
            if(i > prev){
                res++;
                prev = farthest;
            }
            farthest = Math.max(farthest, i + nums[i]);
        }

        return res;
    }
}
