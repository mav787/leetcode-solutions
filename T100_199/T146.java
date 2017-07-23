package T100_199;
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
    private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);		// dummy
    private Node tail = new Node(-1, -1);		// dummy

    public T146(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if( !hs.containsKey(key)) {
            return -1;
        }

        // remove current
        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current to tail
        move_to_tail(current);

        return hs.get(key).value;
    }

    public void put(int key, int value) {
        // this internal `get` method will update the key's position in the linked list.
        if (get(key) != -1) {
            hs.get(key).value = value;
            return;
        }

        if (hs.size() == capacity) {
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key, value);
        hs.put(key, insert);
        move_to_tail(insert);
    }

    private void move_to_tail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}


