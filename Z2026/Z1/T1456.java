package Z2026.Z1;

import java.util.*;

public class T1456 {
    class Solution {
        public int maxVowels(String s, int k) {
            Set<Character> set = new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');

            int res = 0;
            int left = 0, right = 0;

            int count = 0;

            while(right < s.length()){
                char cr = s.charAt(right);
                if(set.contains(cr)){
                    count++;
                }

                right++;

                if(right - left > k){
                    char cl = s.charAt(left);
                    if(set.contains(cl)){
                        count--;
                    }

                    left++;
                }

                res = Math.max(res, count);
            }

            return res;
        }
    }
}
