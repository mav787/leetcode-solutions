package Z2025.T100_999;
import java.util.*;

public class T238 {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        int n = nums.length;
        int[] res = new int[n];

        Arrays.fill(res, 1);
        int product = 1;
        for(int i = 0; i < n; i++){
            res[i] *= product;
            product *= nums[i];
        }

        product = 1;
        for(int i = n - 1; i >= 0; i--){
            res[i] *= product;
            product *= nums[i];
        }

        return res;
    }
}
