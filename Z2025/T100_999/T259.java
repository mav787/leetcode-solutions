package Z2025.T100_999;
import java.util.*;

public class T259 {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        if(nums == null || nums.length < 3){
            return res;
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            res += twoSumSmaller(nums, i + 1, target - nums[i]);
        }

        return res;
    }

    private int twoSumSmaller(int[] nums, int left, int target){
        int res = 0;
        int right = nums.length - 1;
        while(left < right){
            if(nums[left] + nums[right] < target){
                res += right - left;
                left++;
            }
            else{
                right--;
            }
        }

        return res;
    }
}
