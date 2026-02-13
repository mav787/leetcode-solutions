package Z2025.T100_999;

public class T215 {
    // public int findKthLargest(int[] nums, int k) {
    //     Queue<Integer> queue = new PriorityQueue<>();
    //     for(int num : nums){
    //         queue.offer(num);
    //         if(queue.size() > k){
    //             queue.poll();
    //         }
    //     }

    //     return queue.poll();
    // }


    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    // kth largest
    private int quickSelect(int[] nums, int left, int right, int k){
        int pivot = nums[right];
        int curr = left;
        for(int i = left; i < right; i++){
            if(nums[i] > pivot){
                swap(nums, i, curr);
                curr++;
            }
        }

        swap(nums, curr, right);
        if(curr - left == k){
            return nums[curr];
        }
        else if(curr > left + k){
            return quickSelect(nums, left, curr - 1, k);
        }
        else{
            return quickSelect(nums, curr + 1, right, k - (curr - left + 1));
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
