package old.T200_299;
import java.util.*;

public class T297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("# ");
                continue;
            }
            sb.append(node.val + " ");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(" ");
        
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        queue.offer(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            
            if (!values[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.valueOf(values[i]));
                parent.left = left;
                queue.offer(left);
            }
            
            i++;
            
            if (!values[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.valueOf(values[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}
