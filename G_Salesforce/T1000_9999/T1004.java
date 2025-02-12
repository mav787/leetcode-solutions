package G_Salesforce.T1000_9999;

public class T1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int res = 0;
        while(right < nums.length){
            if(nums[right] == 1){
                res = Math.max(res, right - left + 1);
                right++;
            }
            else{
                // nums[right] == 0
                k--;
                while(k < 0){
                    if(nums[left] == 0){
                        k++;
                    }
                    left++;
                }
                res = Math.max(res, right - left + 1);
                right++;
            }
        }

        return res;
    }
}
