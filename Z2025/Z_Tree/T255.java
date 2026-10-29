package Z2025.Z_Tree;

public class T255 {
    int index = 0;

    public boolean verifyPreorder(int[] preorder) {
        helper(preorder, Long.MIN_VALUE, Long.MAX_VALUE);
        return index == preorder.length;
    }

    private void helper(int[] preorder, long minLimit, long maxLimit){
        if(index == preorder.length){
            return;
        }

        int root = preorder[index];

        if(root <= minLimit || root >= maxLimit){
            return;
        }

        index++;

        helper(preorder, minLimit, root);
        helper(preorder, root, maxLimit);
    }

}
