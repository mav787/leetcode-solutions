package Z2025.T10_99;
import java.util.*;

public class T18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4){
            return res;
        }

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j != i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }

                int left = j + 1, right = nums.length - 1;
                while(left < right){
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);

                        left++;
                        right--;
                    }
                    else if(sum < target){
                        left++;
                    }
                    else{
                        right--;
                    }

                    while(left < right && left != j + 1 && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while(left < right && right != nums.length - 1 && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
