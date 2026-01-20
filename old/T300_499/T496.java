package old.T300_499;
import java.util.*;

public class T496 {
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if(findNums == null || nums == null || findNums.length > nums.length)
            return new int[0];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > stack.peek()){
                map.put(stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }
        while (!stack.isEmpty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }
}
