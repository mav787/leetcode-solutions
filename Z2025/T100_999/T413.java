package Z2025.T100_999;

import java.util.*;

public class T413 {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            if(nums.length < 3){
                return 0;
            }


            int res = 0;

            int diff = 0;
            int start = 0;

            for(int i = 1; i < nums.length; i++){
                if(i == 1){
                    diff = nums[i] - nums[i - 1];
                    continue;
                }

                if(nums[i] - nums[i - 1] == diff){
                    continue;
                }
                else{
                    int card = (i - 1) - start + 1;
                    start = i - 1;
                    diff = nums[i] - nums[i - 1];

                    if(card >= 3){
                        res += helper(card);
                    }
                }
            }

            // Process the last arithmetic segment.
            int card = (nums.length - 1) - start + 1;
            if (card >= 3) {
                res += helper(card);
            }

            return res;
        }

        private int helper(int card){
            return (1 + (card - 2)) * (card - 2) / 2;
        }
    }

}
