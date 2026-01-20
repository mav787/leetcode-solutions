package old.T200_299;
import java.util.*;

public class T215Heap {
	public int findKthLargest(int[] nums, int k) {
        if(nums == null)
            return -1;
        Queue<Integer> heap = new PriorityQueue<>(k + 1);
        for(int i = 0; i < nums.length; i++){
            if(heap.size() < k)
                heap.offer(nums[i]);
            else{
                heap.offer(nums[i]);
                heap.poll();
            }
        }
        return heap.poll();
    }
}
