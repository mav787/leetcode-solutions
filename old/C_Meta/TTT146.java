package old.C_Meta;
import java.util.*;

public class TTT146 {		// LRU Cache
	private int capacity;
    private Node head, tail;
    private Map<Integer, Node> map;

    public TTT146(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        int res = node.val;
        moveToTail(node);
        return res;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            moveToTail(node);
            return;
        }
        
        Node newNode = new Node(key, value, tail.prev, tail);
        moveToTail(newNode);
        map.put(key, newNode);
        
        if(map.size() > capacity){
            Node victim = head.next;
            map.remove(victim.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
    }
    
    private void moveToTail(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        node.prev = tail.prev;
        node.next = tail;
        
        tail.prev.next = node;
        tail.prev = node;
    }
}


class Node{
    int key;
    int val;
    Node prev;
    Node next;
    
    public Node(){
        this(0, 0, null, null);
    }
    
    public Node(int key, int value){
        this(key, value, null, null);
    }
    
    public Node(int key, int value, Node prev, Node next){
        this.key = key;
        this.val = value;
        this.prev = prev;
        this.next = next;
    }
}
