package Z2026;

public class T1422 {
    class Solution {
        public int maxScore(String s) {
            int res = 0;

            int ones = 0;
            for(char c : s.toCharArray()){
                if(c == '1'){
                    ones++;
                }
            }

            int zeros = s.length() - ones;

            int left = 0;
            int right = ones;

            for(int i = 0; i < s.length() - 1; i++){
                if(s.charAt(i) == '0'){
                    left++;
                }
                else{
                    right--;
                }
                res = Math.max(res, left + right);
            }

            return res;
        }
    }
}
