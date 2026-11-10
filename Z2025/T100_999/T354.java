package Z2025.T100_999;

import java.util.*;

public class T354 {
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            if(envelopes == null || envelopes.length == 0){
                return 0;
            }

            Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

            List<Integer> list = new ArrayList<>();
            list.add(envelopes[0][1]);

            for(int i = 1; i < envelopes.length; i++){
                helper(envelopes[i][1], list);
            }

            return list.size();
        }

        private void helper(int target, List<Integer> list){
            // find first i that list.get(i) >= target
            int left = 0, right = list.size() - 1;
            while(left + 1 < right){
                int mid = left + (right - left) / 2;
                if(list.get(mid) >= target){
                    right = mid;
                }
                else{
                    left = mid;
                }
            }

            if(list.get(left) >= target){
                list.set(left, target);
            }
            else if(list.get(right) >= target){
                list.set(right, target);
            }
            else{
                list.add(target);
            }
        }
    }
}
