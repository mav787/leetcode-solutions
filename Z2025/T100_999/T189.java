package Z2025.T100_999;

public class T189 {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return;
        }
        k = k % nums.length;

        // 1. O(k * n)
        // for (int i = 0; i < k; i++){rotate once;}

        // 2. O(n), O(k) space
        // copy over last k elements to extra array, shift remaining to right, copy from extra back to left.

        // 3. O(n), O(1) space
        // [1,2,3,4,5,6,7]
        // [4,3,2,1,7,6,5]
        // [5,6,7,1,2,3,4]

        swap(nums, 0, nums.length - k - 1);
        swap(nums, nums.length - k, nums.length - 1);
        swap(nums, 0, nums.length - 1);
    }

    private void swap(int[] nums, int left, int right){
        while(left <= right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }

    }
}
