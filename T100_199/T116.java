package T100_199;
import java.util.*;

public class T116 {
	public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        TreeLinkNode levelstart = root;
        while(levelstart != null){
            TreeLinkNode curr = levelstart;
            while(curr != null){
                if(curr.left != null){
                    curr.left.next = curr.right;
                }
                if(curr.next != null && curr.right != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            levelstart = levelstart.left;
        }
    }
}


class TreeLinkNode{
	TreeLinkNode left;
	TreeLinkNode right;
	TreeLinkNode next;
}