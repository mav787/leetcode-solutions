package T100_199;

public class T117 {
	public void connect(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode pre = dummyHead;
        
        while (root != null) {
    	    if (root.left != null) {
    		    pre.next = root.left;
    		    pre = pre.next;
    	    }
    	    if (root.right != null) {
    		    pre.next = root.right;
    		    pre = pre.next;
    	    }
    	    root = root.next;
    	    if (root == null) {
    		    pre = dummyHead;
    		    root = dummyHead.next;
    		    dummyHead.next = null;
    	    }
        }
    }
	private class TreeLinkNode{
		int val;
		TreeLinkNode left;
		TreeLinkNode right;
		TreeLinkNode next;
		TreeLinkNode(int x) { val = x; }
	}
}




