package old.T300_499;
import java.util.*;
public class T448 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        for (int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                list.add(i + 1);
            }
        }
        return list;
    }
}
