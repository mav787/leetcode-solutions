package Z2026.Z0;

public class T326 {
    class Solution {
        public boolean isPowerOfThree(int n) {
            if(n <= 0){
                return false;
            }
            while(n != 1){
                if(n % 3 != 0){
                    return false;
                }
                n /= 3;
            }

            return true;
        }
    }

}
