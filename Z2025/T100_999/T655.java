package Z2025.T100_999;
import java.util.*;

public class T655 {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        int height = getDepth(root) - 1;
        int m = height + 1, n = (1 << (height + 1)) - 1;
        String[][] res = new String[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(res[i], "");
        }

        helper(res, root, 0, (n - 1) / 2, height);
        return toList(res);
    }

    private void helper(String[][] res, TreeNode node, int r, int c, int height){
        if(node == null){
            return;
        }
        res[r][c] = String.valueOf(node.val);
        if(node.left != null){
            helper(res, node.left, r + 1, c - (1 << (height - r - 1)), height);
        }
        if(node.right != null){
            helper(res, node.right, r + 1, c + (1 << (height - r - 1)), height);
        }
    }

    private List<List<String>> toList(String[][] res){
        List<List<String>> outer = new ArrayList<>();
        for(int i = 0; i < res.length; i++){
            List<String> inner = new ArrayList<>();
            for(int j = 0; j < res[0].length; j++){
                inner.add(res[i][j]);
            }
            outer.add(inner);
        }

        return outer;
    }

    public int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}
