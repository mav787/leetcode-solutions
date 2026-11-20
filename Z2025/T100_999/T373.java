package Z2025.T100_999;

import java.util.*;

public class T373 {
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> res = new ArrayList<>();

            Queue<int[]> heap = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);

            for(int i = 0; i < Math.min(k, nums1.length); i++){
                heap.offer(new int[]{i, 0});
            }

            while(res.size() < k && !heap.isEmpty()){
                int[] curr = heap.poll();
                List<Integer> pair = new ArrayList<>();
                pair.add(nums1[curr[0]]);
                pair.add(nums2[curr[1]]);
                res.add(pair);

                int index = curr[1];
                if(index + 1 < nums2.length){
                    heap.offer(new int[]{curr[0], curr[1] + 1});
                }
            }

            return res;
        }
    }

}
