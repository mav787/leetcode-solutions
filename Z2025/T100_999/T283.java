package Z2025.T100_999;

import java.util.*;

public class T283 {
    public void moveZeroes(int[] nums) {
        int curr = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[curr] = nums[i];
                curr++;
            }
        }

        for(int i = curr; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
