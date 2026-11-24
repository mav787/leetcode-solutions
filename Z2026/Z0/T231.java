package Z2026.Z0;

public class T231 {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if(n < 0){
                return false;
            }

            int count = 0;
            while(n != 0){
                count += (n & 1);
                n >>= 1;
            }

            return count == 1;
        }
    }

}
