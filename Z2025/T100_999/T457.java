package Z2025.T100_999;
import java.util.*;

public class T457 {
    class Solution {
        public boolean circularArrayLoop(int[] nums) {
            if(nums == null || nums.length < 2){
                return false;
            }


            Set<Integer> negative = new HashSet<>();
            for(int i = 0; i < nums.length; i++){
                if(negative.contains(i)){
                    continue;
                }
                if(circleSet(nums, i, negative).size() > 1){
                    return true;
                }
            }

            return false;
        }

        private Set<Integer> circleSet(int[] nums, int i, Set<Integer> negative){
            Set<Integer> set = new HashSet<>();
            int curr = nums[i];
            boolean isForward = curr > 0;

            while(!set.contains(i)){
                if(curr > 0 != isForward){
                    negative.addAll(set);
                    return new HashSet<>();
                }

                set.add(i);
                i = ((i + curr) % nums.length + nums.length) % nums.length;
                curr = nums[i];

                if(Math.abs(curr) % nums.length == 0){
                    negative.addAll(set);
                    return new HashSet<>();
                }
            }

            return set;
        }
    }
}
