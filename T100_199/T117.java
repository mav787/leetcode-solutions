package T100_199;

public class T117 {
	public void connect(TreeLinkNode root) {
        if(root == null) return;
        while(root != null){
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode curr = dummy;
            
            while(root != null){
                if(root.left != null) {
                    // curr is in the current level
                    curr.next = root.left;
                    curr = curr.next;
                }
                if(root.right != null) {
                    curr.next = root.right; 
                    curr = curr.next;
                }
                // root is in the previous level
                root = root.next;
            }
            // go to the next level
            root = dummy.next;
        }
    }
}




















class TreeLinkNode{
	int val;
	TreeLinkNode left;
	TreeLinkNode right;
	TreeLinkNode next;
	TreeLinkNode(int x) { val = x; }
}

