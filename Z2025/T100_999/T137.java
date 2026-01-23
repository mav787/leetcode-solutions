package Z2025.T100_999;

public class T137 {
    public int singleNumber(int[] nums) {
        int res = 0;

        for(int i = 0; i < 32; i++){
            int bit = 0;
            for(int num : nums){
                bit += (num >> i) & 1;
                if(bit == 3){
                    bit = 0;
                }
            }

            res += bit << i;
        }

        return res;
    }
}
