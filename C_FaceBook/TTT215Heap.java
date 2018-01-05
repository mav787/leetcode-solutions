package C_FaceBook;
import java.util.*;

public class TTT215Heap {
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 1 || k > nums.length) return -1;
        Queue<Integer> heap = new PriorityQueue<>();
        for(int item : nums){
            heap.offer(item);
            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}
