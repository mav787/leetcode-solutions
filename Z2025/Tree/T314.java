package Z2025.Tree;

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

            Map<Integer, List<Integer>> map = new TreeMap<>();

            Queue<TreeNode> queue = new LinkedList<>();
            Queue<Integer> indices = new LinkedList<>();
            queue.offer(root);
            indices.offer(0);

            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                int index = indices.poll();

                List<Integer> list = map.getOrDefault(index, new ArrayList<>());
                list.add(node.val);
                map.put(index, list);

                if(node.left != null){
                    queue.offer(node.left);
                    indices.offer(index - 1);
                }

                if(node.right != null){
                    queue.offer(node.right);
                    indices.offer(index + 1);
                }
            }


            for(int index : map.keySet()){
                res.add(map.get(index));
            }
            return res;
        }
    }
}
