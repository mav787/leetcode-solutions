package D_Microsoft;

public class TTT116 {
	public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode levelStart = root;
        while(levelStart != null){
            TreeLinkNode curr = levelStart;
            while(curr != null){
                if(curr.left != null){
                    curr.left.next = curr.right;
                }
                if(curr.next != null && curr.right != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            levelStart = levelStart.left;
        }
    }
}




















class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
	  }