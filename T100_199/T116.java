package T100_199;

public class T116 {
	public void connect(TreeLinkNode root) {
        if(root == null) return ;
        TreeLinkNode start = root;
        while(start != null){
            TreeLinkNode curr = start;
            while(curr != null){
                if(curr.left != null) curr.left.next = curr.right;
                if(curr.next != null && curr.right != null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            start = start.left;
        }

    }
}


