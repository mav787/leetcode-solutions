package T100_199;
import java.util.*;
public class T117My {
	public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<TreeLinkNode> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeLinkNode node = queue.poll();
                list.add(node);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            
            for(int i = 0; i < list.size() - 1; i++){
                list.get(i).next = list.get(i + 1);    
            }
        }
    }
}
