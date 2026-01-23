package Z2025.T100_999;
import java.util.*;

public class T146 {
    class DNode{
        int key;
        int val;
        DNode prev;
        DNode next;

        public DNode(int key, int val){
            this.key = key;
            this.val = val;
        }

        public DNode(int key, int val, DNode prev, DNode next){
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    class DList{
        DNode head;
        DNode tail;
        int size;

        public DList(){
            head = new DNode(0, 0);
            tail = new DNode(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        public void moveToTail(DNode node){
            DNode prev = node.prev, next = node.next;
            if(prev != null){
                prev.next = next;
            }

            if(next != null){
                next.prev = prev;
            }

            tail.prev.next = node;
            node.prev = tail.prev;

            tail.prev = node;
            node.next = tail;
        }

        public void insert(DNode node){
            moveToTail(node);
            size++;
        }

        public int removeFromHead(){
            if(size == 0){
                return -1;
            }

            size--;
            DNode victim = head.next;

            head.next = head.next.next;
            head.next.prev = head;

            victim.prev = null;
            victim.next = null;

            return victim.key;
        }
    }

    int capacity;
    DList list;
    Map<Integer, DNode> map;

    public T146(int capacity) {
        this.capacity = capacity;
        this.list = new DList();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        DNode node = map.get(key);
        list.moveToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DNode node = map.get(key);
            node.val = value;
            list.moveToTail(node);
        }
        else{
            DNode node = new DNode(key, value);
            map.put(key, node);
            list.insert(node);
            if(list.size > capacity){
                int keyToRemove = list.removeFromHead();
                map.remove(keyToRemove);
            }
        }
    }
}
