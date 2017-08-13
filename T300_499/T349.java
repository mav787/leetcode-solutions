package T300_499;
import java.util.*;

public class T349 {
	public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }
            else if(nums1[i] == nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
                while(i < nums1.length && nums1[i] == nums1[i - 1]) i++;
                while(j < nums2.length && nums2[j] == nums2[j - 1]) j++;
            }
            else{
                j++;
            }
        }
        
        int[] ret = new int[res.size()];
        for(int k = 0; k < ret.length; k++){
            ret[k] = res.get(k);
        }
        return ret;
    }
}
