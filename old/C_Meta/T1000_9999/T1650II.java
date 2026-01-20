package old.C_Meta.T1000_9999;

public class T1650II {
    public Node lowestCommonAncestor(Node p, Node q) {
        int pDepth = getDepth(p);
        int qDepth = getDepth(q);

        if(pDepth < qDepth){
            int temp = pDepth;
            pDepth = qDepth;
            qDepth = temp;

            Node tempNode = p;
            p = q;
            q = tempNode;
        }

        // now pDepth >= qDepth
        for(int i = 0; i < pDepth - qDepth; i++){
            p = p.parent;
        }

        while(p != null && q != null){
            if(p == q){
                return p;
            }
            p = p.parent;
            q = q.parent;
        }
        return null;
    }

    private int getDepth(Node p){
        int res = 0;
        while(p != null){
            p = p.parent;
            res++;
        }
        return res;
    }
}
