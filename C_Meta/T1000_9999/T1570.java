package C_Meta.T1000_9999;
import java.util.*;
public class T1570 {
    class SparseVector {
        Map<Integer, Integer> map;

        SparseVector(int[] nums) {
            map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    map.put(i, nums[i]);
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            Map<Integer, Integer> map1 = this.map;
            Map<Integer, Integer> map2 = vec.map;

            if(map1.keySet().size() > map2.keySet().size()){
                Map<Integer, Integer> temp = map1;
                map1 = map2;
                map2 = temp;
            }

            // map1.keyset.size <= map2.keyset.size
            int res = 0;
            for(int key : map1.keySet()){
                if(map2.containsKey(key)){
                    res += map1.get(key) * map2.get(key);
                }
            }
            return res;
        }
    }

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
}
