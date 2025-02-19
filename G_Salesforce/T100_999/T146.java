package G_Salesforce.T100_999;
import java.util.*;

public class T146 {
    Map<Integer, DNode> map;
    DNode head;
    DNode tail;
    int capacity;

    public T146(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new DNode(0, 0);
        tail = new DNode(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        DNode node = map.get(key);
        remove(node);
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DNode node = map.get(key);
            node.value = value;
            remove(node);
            moveToTail(node);
        }
        else{
            if(map.size() == capacity){
                DNode victim = deleteFromHead();
                map.remove(victim.key);
            }

            DNode node = new DNode(key, value);
            map.put(key, node);
            moveToTail(node);
        }
    }


    private void remove(DNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void moveToTail(DNode node){
        DNode pre = tail.prev;
        pre.next = node;
        node.prev = pre;

        node.next = tail;
        tail.prev = node;
    }

    private DNode deleteFromHead(){
        DNode node = head.next;
        DNode next = node.next;

        next.prev = head;
        head.next = next;

        node.prev = null;
        node.next = null;
        return node;
    }


    class DNode{
        int key;
        int value;
        DNode prev;
        DNode next;

        public DNode(int k, int v){
            this.key = k;
            this.value = v;
        }
    }
}
