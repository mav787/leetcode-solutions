package old.T200_299;
import java.util.*;

public class T239Deque {
	public int[] maxSlidingWindow(int[] nums, int k) {		
		if (nums == null || k < 1 || k > nums.length) {
			return new int[0];
		}

		int[] res = new int[nums.length - k + 1];
		int curr = 0;
		// store index
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			// remove numbers out of range k
			while (!deque.isEmpty() && deque.peek() < i - k + 1) {
				deque.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			// q contains index... r contains content
			deque.offer(i);
			if (i >= k - 1) {
				res[curr] = nums[deque.peek()];
				curr++;
			}
		}
		return res;
	}
}
