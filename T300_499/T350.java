package T300_499;
import java.util.*;

public class T350 {
	public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(int i : nums2){
            if(map.containsKey(i) && map.get(i) > 0){
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
