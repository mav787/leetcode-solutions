package old.C_Meta.T1000_9999;
import java.util.*;

public class T1650 {
    public Node lowestCommonAncestor(Node p, Node q) {
        if(p == null || q == null){
            return null;
        }

        Set<Node> set = new HashSet<>();

        while(p != null){
            set.add(p);
            p = p.parent;
        }

        while(q != null){
            if(set.contains(q)){
                return q;
            }
            q = q.parent;
        }

        return null;
    }
}
