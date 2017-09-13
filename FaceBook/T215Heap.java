package FaceBook;
import java.util.*;

public class T215Heap {
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length) return Integer.MIN_VALUE;
        Queue<Integer> heap = new PriorityQueue<Integer>();
        for(int i = 0; i < nums.length; i++){
            heap.offer(nums[i]);
            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}
