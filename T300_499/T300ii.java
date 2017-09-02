package T300_499;
import java.util.*;
public class T300ii {
	public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) 
            	i = -(i + 1);
            dp[i] = x;
            if(i == len) 
            	len++;
        }
        return len;
    }
	
//	Note: Arrays.binarySearch() method returns index of the search key,
//	if it is contained in the array, else it returns (-(insertion point) - 1). 
//	The insertion point is the point at which the key would be inserted into 
//	the array: the index of the first element greater than the key, or a.length 
//	if all elements in the array are less than the specified key.
	
	// https://leetcode.com/articles/longest-increasing-subsequence/
}
