package Z2025.T100_999;
import java.util.*;

public class T128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        if(nums == null || nums.length == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int i = 0;
        while(i < nums.length){
            int count = 1;
            set.remove(nums[i]);

            int num = nums[i];
            while(set.contains(num - 1)){
                set.remove(num - 1);
                num--;
                count++;
            }

            num = nums[i];
            while(set.contains(num + 1)){
                set.remove(num + 1);
                num++;
                count++;
            }

            res = Math.max(res, count);
            while(i < nums.length && !set.contains(nums[i])){
                i++;
            }
        }

        return res;
    }
}
