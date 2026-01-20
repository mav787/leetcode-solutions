package old.C_Meta;
import java.util.*;

public class TTT215QuickSelectII {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            list.add(num);
        }

        return quickSelect(list, k);
    }

    public int quickSelect(List<Integer> nums, int k) {
        int pivot = nums.size() - 1;

        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i = 0; i < nums.size(); i++){
            if(nums.get(i) < nums.get(pivot)){
                left.add(nums.get(i));
            }
            else if(nums.get(i) == nums.get(pivot)){
                mid.add(nums.get(i));
            }
            else{
                right.add(nums.get(i));
            }
        }

        if(right.size() >= k){
            return quickSelect(right, k);
        }
        else if(right.size() + mid.size() < k){
            return quickSelect(left, k - right.size() - mid.size());
        }
        else{
            return nums.get(pivot);
        }
    }
}
