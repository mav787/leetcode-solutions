package Z2025.T100_999;
import java.util.*;

public class T138 {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        copyNodes(head, map);
        copyPointers(head, map);
        return map.get(head);
    }

    private void copyNodes(Node head, Map<Node, Node> map){
        if(head == null){
            return;
        }

        map.put(head, new Node(head.val));
        copyNodes(head.next, map);
    }

    private void copyPointers(Node head, Map<Node, Node> map){
        if(head == null){
            return;
        }

        map.get(head).next = map.get(head.next);
        map.get(head).random = map.get(head.random);

        copyPointers(head.next, map);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
