package Z2025.T100_999;

import java.util.*;

public class T350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : nums2){
            if(map.containsKey(num)){
                res.add(num);
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0){
                    map.remove(num);
                }
            }
        }

        int[] ret = new int[res.size()];

        for(int i = 0; i < ret.length; i++){
            ret[i] = res.get(i);
        }

        return ret;
    }

}
