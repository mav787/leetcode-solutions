package Z2025.Z_Tree;

import java.util.*;

public class T559 {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }

        int max = 0;
        for(Node child : root.children){
            max = Math.max(max, maxDepth(child));
        }

        return max + 1;
    }

}
