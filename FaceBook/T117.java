package FaceBook;

public class T117 {
	public void connect(TreeLinkNode root) {
        while(root != null){
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode curr = dummy;
            while(root != null){
                if(root.left != null) {
                    curr.next = root.left;
                    curr = curr.next;
                }
                if(root.right != null) {
                    curr.next = root.right; 
                    curr = curr.next;
                }
                root = root.next;
            }
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

