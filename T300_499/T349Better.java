package T300_499;
import java.util.*;
public class T349Better {
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        Set<Integer> set = new HashSet<>();
        for(int i : nums1){
            set.add(i);
        }
        
        for(int j : nums2){
            if(set.contains(j)){
                res.add(j);
            }
        }
        
        int[] arr = new int[res.size()];
        int index = 0;
        for(int item : res){
            arr[index++] = item;
       }
       return arr;
    }
}
