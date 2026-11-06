package Z2025.T100_999;
import java.util.*;

public class T314 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null){
                return res;
            }

            Queue<TreeNode> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();
            Map<Integer, List<Integer>> map = new HashMap<>();

            int min = 0, max = 0;
            q1.offer(root);
            q2.offer(0);

            while(!q1.isEmpty()){
                TreeNode node = q1.poll();
                int x = q2.poll();

                List<Integer> list = map.getOrDefault(x, new ArrayList<>());
                list.add(node.val);
                map.put(x, list);

                min = Math.min(min, x);
                max = Math.max(max, x);

                if(node.left != null){
                    q1.offer(node.left);
                    q2.offer(x - 1);
                }

                if(node.right != null){
                    q1.offer(node.right);
                    q2.offer(x + 1);
                }
            }

            for(int i = min; i <= max; i++){
                if(map.containsKey(i)){
                    res.add(map.get(i));
                }
            }

            return res;
        }
    }
}
