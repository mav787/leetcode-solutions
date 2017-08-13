package T200_299;

public class T298 {
	public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(dfs(root.left, 1, root.val), dfs(root.right, 1, root.val));
    }
    
    public int dfs(TreeNode root, int count, int val){
        if(root == null) 
            return count;
        if(root.val == val + 1){
            count++;
        }else{
            count = 1;
        }
        int left = dfs(root.left, count, root.val);
        int right = dfs(root.right, count, root.val);
        return Math.max(Math.max(left, right), count);
    }
}