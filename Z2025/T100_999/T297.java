package Z2025.T100_999;

import java.util.*;

public class T297 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {
        // BFS order, divisor is ","
        // "root,left,right"
        // substitute nulls with "#"'s
        // if parent is "#" then children are skipped



        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            queue.offer(root);

            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node == null){
                    sb.append("#");
                    sb.append(",");
                }
                else{
                    sb.append(node.val);
                    sb.append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }

            sb.setLength(sb.length() - 1);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] sa = data.split(",");
            // need to simultaneously maintain TreeNode references in parent level and children level, in order to set up pointers
            // need to return root at the end

            TreeNode root = null;
            if(sa[0].equals("#")){
                return root;
            }

            root = new TreeNode(Integer.valueOf(sa[0]));
            List<TreeNode> parents = new ArrayList<>();
            parents.add(root);

            // global cursor in sa[]
            int curr = 1;

            while(curr < sa.length){
                List<TreeNode> children = new ArrayList<>();
                for(int i = 0; i < parents.size(); i++){
                    TreeNode parent = parents.get(i);
                    if(parent == null){
                        continue;
                    }
                    TreeNode left = getNode(sa, curr);
                    curr++;
                    TreeNode right = getNode(sa, curr);
                    curr++;

                    parent.left = left;
                    parent.right = right;

                    children.add(left);
                    children.add(right);
                }

                parents = children;
                children = new ArrayList<>();
            }

            return root;
        }


        private TreeNode getNode(String[] sa, int curr){
            String s = sa[curr];
            if(s.equals("#")){
                return null;
            }

            return new TreeNode(Integer.valueOf(s));
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

}
