package Z2025.T100_999;

import java.util.*;

public class T334 {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3){
            return false;
        }

        int i = 0, j = -1;

        for(int k = 1; k < nums.length; k++){
            if(nums[k] <= nums[i]){
                i = k;
            }

            else if(j == -1 || nums[k] <= nums[j]){
                j = k;
            }

            else{
                return true;
            }
        }

        return false;
    }

}
