package Z2025.T100_999;

public class T136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums){
            res ^= num;
        }

        return res;
    }
}
