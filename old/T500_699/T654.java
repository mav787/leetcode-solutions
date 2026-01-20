package old.T500_699;

public class T654 {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return construct(nums, 0, nums.length - 1);
    }
    
    private TreeNode construct(int[] nums, int left, int right){
        if(left > right) return null;
        int index = left, max = nums[left];
        for(int i = left; i <= right; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        
        TreeNode root = new TreeNode(max);
        root.left = construct(nums, left, index - 1);
        root.right = construct(nums, index + 1, right);
        return root;
    }
}
