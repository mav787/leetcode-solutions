package old.T200_299;
import java.util.*;
public class T257prime {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        if(root == null) 
            return paths;
        if(root.left == null && root.right == null){
            paths.add(root.val+"");
            return paths;
        }
         for (String path : binaryTreePaths(root.left)) {
             paths.add(root.val + "->" + path);
         }
         for (String path : binaryTreePaths(root.right)) {
             paths.add(root.val + "->" + path);
         }
         return paths;
    }
}
