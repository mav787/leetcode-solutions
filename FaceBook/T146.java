package FaceBook;
import java.util.*;

public class T146 {		// LRU Cache
    class Node{
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);		// dummy
    private Node tail = new Node(-1, -1);		// dummy

    public T146(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if( !map.containsKey(key)) {
            return -1;
        }

        // remove current
        Node current = map.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current to tail
        moveToTail(current);

        return map.get(key).value;
    }

    public void put(int key, int value) {
        // this internal `get` method will update the key's position in the linked list.
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }

    private void moveToTail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}
