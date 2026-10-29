package Z2025.Z_Tree;

public class T235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q){
            return root;
        }

        if(p.val > q.val){
            return lowestCommonAncestor(root, q, p);
        }

        // p.val < q.val now

        if(q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

}
