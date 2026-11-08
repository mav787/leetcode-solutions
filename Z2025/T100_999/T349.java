package Z2025.T100_999;

import java.util.*;

public class T349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for(int num : nums1){
            set.add(num);
        }

        for(int num : nums2){
            if(set.contains(num)){
                res.add(num);
            }
        }

        int[] ret = new int[res.size()];
        int i = 0;

        for(int item : res){
            ret[i] = item;
            i++;
        }

        return ret;
    }

}
