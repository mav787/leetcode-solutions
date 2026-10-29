package Z2025.Z_Tree;

public class T117 {
    public Node connect(Node root) {
        Node curr = root;

        while(curr != null){
            Node dummy = new Node(0);
            Node tail = dummy;

            while(curr != null){
                if(curr.left != null){
                    tail.next = curr.left;
                    tail = tail.next;
                }

                if(curr.right != null){
                    tail.next = curr.right;
                    tail = tail.next;
                }

                curr = curr.next;
            }

            curr = dummy.next;
        }

        return root;
    }

}
