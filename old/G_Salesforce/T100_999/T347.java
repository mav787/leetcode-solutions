package old.G_Salesforce.T100_999;
import java.util.*;

public class T347 {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || k > nums.length){
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int num : map.keySet()){
            heap.offer(num);
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = heap.poll();
        }

        return res;
    }
}
