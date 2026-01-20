package Z2025.T10_99;
import java.util.*;

public class T47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }

        Arrays.sort(nums);
        backtrack(res, nums, new boolean[nums.length], new ArrayList<Integer>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }

            if(i != 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }

            list.add(nums[i]);
            used[i] = true;

            backtrack(res, nums, used, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
