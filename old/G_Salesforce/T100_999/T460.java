package old.G_Salesforce.T100_999;
import java.util.*;

public class T460 {
    int capacity;
    Map<Integer, DList> freqMap;
    Map<Integer, DNode> map;


    public T460(int capacity) {
        this.capacity = capacity;
        this.freqMap = new TreeMap<>();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        DNode node = map.get(key);
        int freq = node.freq;

        node.freq++;

        node.remove(); // remove itself from freqMap
        DList dList = freqMap.getOrDefault(freq + 1, new DList());
        dList.add(node); // add node to freqMap
        freqMap.put(freq + 1, dList);

        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            // update
            DNode node = map.get(key);
            int freq = node.freq;

            node.freq++;
            node.value = value;

            node.remove(); // remove itself from freqMap
            DList dList = freqMap.getOrDefault(freq + 1, new DList());
            dList.add(node); // add node to freqMap
            freqMap.put(freq + 1, dList);
        }
        else{
            // insert
            if(map.size() == capacity){
                int lowestFreq = -1;
                Set<Integer> keysToRemove = new HashSet<>();

                for(int candidate : freqMap.keySet()){
                    if(freqMap.get(candidate).isEmpty()){
                        keysToRemove.add(candidate);
                    }
                    else {
                        lowestFreq = candidate;
                        break;      // get the 1st key in freqMap to evict
                    }
                }

                for(int keyToRemove : keysToRemove){
                    freqMap.remove(keyToRemove);
                }

                DList dList = freqMap.get(lowestFreq);
                DNode victim = dList.remove();
                if(dList.isEmpty()){
                    freqMap.remove(lowestFreq);
                }
                map.remove(victim.key);
            }

            DNode node = new DNode(key, value);
            map.put(key, node);
            DList dList = freqMap.getOrDefault(1, new DList());
            dList.add(node);
            freqMap.put(1, dList);
        }
    }


    class DList{
        DNode head;
        DNode tail;

        public DList(){
            this.head = new DNode(0, 0);
            this.tail = new DNode(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        public void add(DNode node){
            DNode prev = tail.prev;

            prev.next = node;
            node.prev = prev;

            node.next = tail;
            tail.prev = node;
        }

        public DNode remove(){
            if(this.isEmpty()){
                return null;
            }

            DNode victim = head.next;
            victim.remove();
            return victim;
        }

        public boolean isEmpty(){
            return head.next == tail;
        }

        public String toString(){
            if(head.next == tail){
                return "__EMPTY__";
            }
            String connector = " -> ";
            StringBuilder sb = new StringBuilder();
            DNode curr = head.next;
            while(curr != tail){
                sb.append(curr.toString());

                curr = curr.next;
                sb.append(connector);
            }
            return sb.substring(0, sb.length() - connector.length());
        }
    }

    class DNode{
        int key;
        int value;
        int freq;


        DNode prev;
        DNode next;

        public DNode(int key, int value){
            this.key = key;
            this.value = value;
            this.freq = 1;
        }

        public void remove(){
            this.prev.next = this.next;
            this.next.prev = this.prev;

            this.prev = null;
            this.next = null;
        }

        public String toString(){
            return "k: " + key + ", value: " + value + ", freq:" + freq + " ";
        }
    }

    public static void main(String[] args){
        T460 t460 = new T460(2);
        t460.put(1, 1);
        t460.put(2, 2);
        t460.get(1);
        t460.put(3, 3);
        t460.get(2);
        t460.get(3);
        t460.put(4, 4);
        t460.get(1);
        t460.get(3);
        t460.get(4);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */