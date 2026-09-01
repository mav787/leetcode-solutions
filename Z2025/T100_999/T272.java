package Z2025.T100_999;

import java.util.*;

public class T272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if (root == null || k <= 0) {
            return new ArrayList<>();
        }

        // 1. initialize deque for sliding window
        Deque<Integer> queue = new LinkedList<>();

        // 2. inorder traverse to collect k closest values
        inorder(root, target, k, queue);

        // 3. return result list from queue
        return new ArrayList<>(queue);
    }

    private void inorder(TreeNode curr, double target, int k, Deque<Integer> queue) {
        if (curr == null) {
            return;
        }

        // traverse left subtree
        inorder(curr.left, target, k, queue);

        // process current node: always offer first, then check size
        queue.offerLast(curr.val);

        if (queue.size() > k) {
            double lastErr = Math.abs(queue.peekLast() - target);
            double firstErr = Math.abs(queue.peekFirst() - target);

            // if newly added node is closer, kick out the oldest head
            if (lastErr < firstErr) {
                queue.pollFirst();
            } else {
                // prune: current is further, remove the newly added tail and stop
                queue.pollLast();
                // return;
            }
        }

        // traverse right subtree
        inorder(curr.right, target, k, queue);
    }
}
