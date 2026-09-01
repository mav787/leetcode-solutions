package Z2025.T100_999;


import java.util.*;

public class T268 {
    public int missingNumber(int[] nums) {
        int expected = 0, actual = 0;
        for(int i = 0; i < nums.length; i++){
            actual += nums[i];
            expected += (i + 1);
        }

        return expected - actual;
    }
}
