package T300_499;

public class T303 {
	private int[] sum;

    public T303(int[] nums) {
        if(nums == null || nums.length == 0){
            sum = new int[0];
        }
        else{
            sum = new int[nums.length + 1];
            sum[0] = 0;
            int temp = 0;
            for(int i = 1; i <= nums.length; i++){
                temp += nums[i - 1];
                sum[i] = temp;
            }
        }
    }
    
    public int sumRange(int i, int j) {
        if(i > j) return -1;
        return sum[j + 1] - sum[i];
    }
}
