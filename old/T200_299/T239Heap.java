package old.T200_299;
import java.util.*;

public class T239Heap {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k < 1 || k > nums.length)
            return new int[0];
        int[] res = new int[nums.length - k + 1];
        Queue<Integer> heap = new PriorityQueue<>(k, Collections.reverseOrder());
        for(int i = 0; i < k; i++){
            heap.offer(nums[i]);
        }
        for(int i = k; i < nums.length; i++){
            res[i - k] = heap.peek();
            heap.remove(nums[i - k]);
            heap.offer(nums[i]);
        }
        
        res[nums.length - k] = heap.peek();
        return res;
    }
}
