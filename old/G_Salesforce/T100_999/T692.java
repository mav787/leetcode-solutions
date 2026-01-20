package old.G_Salesforce.T100_999;
import java.util.*;

public class T692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        Queue<String> heap = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));


        for(String s : words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(String key : map.keySet()){
            heap.offer(key);
            if(heap.size() > k){
                heap.poll();
            }
        }

        List<String> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
