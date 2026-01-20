package old.G_Salesforce.T1000_9999;

public class T1150 {
    public boolean isMajorityElement(int[] nums, int target) {
        // 1. search left most
        // 2. search right most
        // 3. calculate diff

        int left = findLeft(nums, target);
        return left != -1 && left + nums.length / 2 < nums.length && nums[left + nums.length / 2] == target;
    }

    private int findLeft(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid;
            }
            else{
                left = mid;
            }
        }

        if(nums[left] == target){
            return left;
        }
        else if(nums[right] == target){
            return right;
        }
        else{
            return -1;
        }
    }
}
