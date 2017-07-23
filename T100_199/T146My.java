package T100_199;
import java.util.*;

public class T146My {
    
    private DListNode head, tail;
    private Map<Integer, DListNode> map;
    private int capacity;
    
    public T146My(int capacity) {
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.prev = head;
        
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        DListNode node = map.get(key);
        int res = node.val;
        // tail is most recently used
        // head is least recently used
        moveToTail(node);
        return res;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            DListNode node = map.get(key);
            node.val = value;
            moveToTail(node);
        }
        else{
            DListNode node = new DListNode(key, value, tail.prev, tail);
            map.put(key, node);
            tail.prev.next = node;
            tail.prev = node;
        }
        
        if(map.size() > capacity){
            DListNode LRU = head.next;
            head.next = head.next.next;
            head.next.prev = head;
            
            map.remove(LRU.key);
        }
    }
    
    
    
    private void moveToTail(DListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        DListNode pre = tail.prev;
        node.prev = pre;
        node.next = tail;
        
        pre.next = node;
        tail.prev = node;
        
    }
}

class DListNode{
    int key;
    int val;
    DListNode prev;
    DListNode next;
    public DListNode(){
        this(0, 0, null, null);
    }
    
    public DListNode(int k, int v){
        this(k, v, null, null);
    }
    
    public DListNode(int k, int v, DListNode pre, DListNode nex){
        this.key = k;
        this.val = v;
        this.prev = pre;
        this.next = nex;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
