package Z2025.T100_999;

import java.util.*;

public class T347 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            int[] res = new int[k];

            Queue<Helper> heap = new PriorityQueue<>((a, b) -> a.count - b.count);
            Map<Integer, Integer> map = new HashMap<>();

            for(int i = 0; i < nums.length; i++){
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            for(int key : map.keySet()){
                heap.offer(new Helper(key, map.get(key)));
                if(heap.size() > k){
                    heap.poll();
                }
            }

            for(int i = 0; i < k; i++){
                res[i] = heap.poll().key;
            }
            return res;
        }

        class Helper{
            int key;
            int count;

            public Helper(int key, int count){
                this.key = key;
                this.count = count;
            }
        }
    }

}
