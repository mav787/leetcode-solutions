package Z2025.T100_999;

import java.util.*;

public class T401 {
    class Solution {
        int[] hours = {1, 2, 4, 8};
        int[] mins = {1, 2, 4, 8, 16, 32};

        public List<String> readBinaryWatch(int turnedOn) {
            List<String> res = new ArrayList<>();

            for(int i = 0; i <= turnedOn; i++){
                List<Integer> hList = new ArrayList<>();
                helper(hList, hours, i, 11, 0, 0);

                List<Integer> mList = new ArrayList<>();
                helper(mList, mins, turnedOn - i, 59, 0, 0);

                for(int hour : hList){
                    for(int min : mList){
                        res.add(hour + ":" + (min < 10 ? "0" + min : "" + min));
                    }
                }
            }

            return res;
        }

        private void helper(List<Integer> list, int[] elements, int quota, int limit, int curr, int start){
            if(quota < 0){
                return;
            }
            if(curr > limit){
                return;
            }
            if(quota == 0){
                list.add(curr);
                return;
            }

            for(int i = start; i < elements.length; i++){
                helper(list, elements, quota - 1, limit, curr + elements[i], i + 1);
            }
        }
    }
}
