package old.T100_199;
import java.util.*;

public class T106ii {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
		int len = inorder.length;
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < len; i++){
			map.put(inorder[i], i);
		}
		
		return buildTree(inorder, 0, len - 1, postorder, 0, len - 1, map);
	}

	private TreeNode buildTree(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd, Map<Integer,Integer> map){
		if (pStart > pEnd || iStart > iEnd) return null;
		int rootval = postorder[pEnd];
		TreeNode root = new TreeNode(rootval);
		int index = map.get(rootval);
		TreeNode left = buildTree(inorder, iStart, index - 1, postorder, pStart, pStart + index - iStart - 1, map);
		TreeNode right = buildTree(inorder,index + 1, iEnd, postorder, pStart + index - iStart, pEnd - 1, map);
		root.left = left;
		root.right = right;
		return root;
	}
}
