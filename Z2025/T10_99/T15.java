package Z2025.T10_99;
import java.util.*;

public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        if(nums == null || nums.length < 3){
            return res;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);

                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
                else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                }
                else{
                    right--;
                    while(left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
