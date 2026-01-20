package old.G_Salesforce.T10_99;
import java.util.*;

public class T90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }

        Arrays.sort(nums);

        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
        res.add(new ArrayList<>(list));

        for(int i = index; i < nums.length; i++){
            if(i != index && nums[i] == nums[i - 1]){
                continue;
            }

            list.add(nums[i]);
            backtrack(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
