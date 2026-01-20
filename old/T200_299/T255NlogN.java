package old.T200_299;

public class T255NlogN {
	public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length < 2)
            return true;
        return verifyPreorder(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean verifyPreorder(int[] preorder, int startIndex, int endIndex, int min, int max){
        if(startIndex > endIndex)
            return true;
        int root = preorder[startIndex];
        if(root < min || root > max)
            return false;
        int rightIndex = startIndex;
        for(; rightIndex <= endIndex; rightIndex++){
            if(preorder[rightIndex] > root)
                break;
        }
        
        return verifyPreorder(preorder, startIndex + 1, rightIndex - 1, min, root) && verifyPreorder(preorder, rightIndex, endIndex, root, max);
    }
}
