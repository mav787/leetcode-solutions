package old.T300_499;
import java.util.*;
public class T460 {

    class Node {
        public int count;
        public LinkedHashSet<Integer> keys;
        public Node prev, next;

        public Node(int count) {
            this.count = count;
            keys = new LinkedHashSet<>();
            prev = next = null;
        }
    }

	private Node head;
    private int cap;
    private HashMap<Integer, Integer> freqMap;
    private HashMap<Integer, Node> map;
    
    public T460(int capacity) {
        this.cap = capacity;
        freqMap = new HashMap<>();
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (freqMap.containsKey(key)) {
            increaseCount(key);
            return freqMap.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if ( cap == 0 ) return;
        if (freqMap.containsKey(key)) {
            freqMap.put(key, value);
        } else {
            if (freqMap.size() < cap) {
                freqMap.put(key, value);
            } else {
                removeOld();
                freqMap.put(key, value);
            }
            addToHead(key);
        }
        increaseCount(key);
    }
    
    private void addToHead(int key) {
        if (head == null) {
            head = new Node(0);
            head.keys.add(key);
        } else if (head.count > 0) {
            Node node = new Node(0);
            node.keys.add(key);
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            head.keys.add(key);
        }
        map.put(key, head);
    }
    
    private void increaseCount(int key) {
        Node node = map.get(key);
        node.keys.remove(key);
        
        if (node.next == null) {
            node.next = new Node(node.count + 1);
            node.next.prev = node;
            node.next.keys.add(key);
        } else if (node.next.count == node.count + 1) {
            node.next.keys.add(key);
        } else {
            Node tmp = new Node(node.count + 1);
            tmp.keys.add(key);
            tmp.prev = node;
            tmp.next = node.next;
            node.next.prev = tmp;
            node.next = tmp;
        }

        map.put(key, node.next);
        if (node.keys.size() == 0) remove(node);
    }
    
    private void removeOld() {
        if (head == null) return;
        int old = 0;
        for (int n: head.keys) {
            old = n;
            break;
        }
        head.keys.remove(old);
        if (head.keys.size() == 0) remove(head);
        map.remove(old);
        freqMap.remove(old);
    }
    
    private void remove(Node node) {
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        } 
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }
    

}
