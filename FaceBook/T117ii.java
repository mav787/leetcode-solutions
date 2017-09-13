package FaceBook;

public class T117ii {
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
