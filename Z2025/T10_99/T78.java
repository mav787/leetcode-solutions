package Z2025.T10_99;
import java.util.*;

public class T78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null){
            return res;
        }

        Arrays.sort(nums);
        helper(res, nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, int index, List<Integer> list){
        res.add(new ArrayList<>(list));

        for(int i = index; i < nums.length; i++){
            if(i != index && nums[i] == nums[i - 1]){
                continue;
            }

            list.add(nums[i]);
            helper(res, nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
