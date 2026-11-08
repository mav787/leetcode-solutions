package Z2025.T100_999;

import java.util.*;

public class T351 {
    class Solution {
        public int numberOfPatterns(int m, int n) {
            int res = 0;
            for(int i = m; i <= n; i++){
                res += numberOfPatterns(i);
            }

            return res;
        }

        private int numberOfPatterns(int buttons){
            int res = 0;
            for(int src = 1; src <= 9; src++){
                // starting from 'src', we have 'buttons' left, 'set' is what is already used
                res += helper(src, buttons, new HashSet<>());
            }

            return res;
        }

        // buttons: including src
        private int helper(int src, int buttons, Set<Integer> used){
            if(buttons == 1){
                return 1;
            }

            int res = 0;
            used.add(src);

            for(int dest = 1; dest <= 9; dest++){
                if(!used.contains(dest) && isValid(src, dest, used)){
                    res += helper(dest, buttons - 1, used);
                }
            }

            used.remove(src);
            return res;
        }

        private boolean isValid(int src, int dest, Set<Integer> used){
            if(src == 1){
                if(dest == 3) return used.contains(2);
                if(dest == 7) return used.contains(4);
                if(dest == 9) return used.contains(5);
            }

            if(src == 2){
                if(dest == 8) return used.contains(5);
            }

            if(src == 3){
                if(dest == 1) return used.contains(2);
                if(dest == 7) return used.contains(5);
                if(dest == 9) return used.contains(6);
            }

            if(src == 4){
                if(dest == 6) return used.contains(5);
            }

            if(src == 6){
                if(dest == 4) return used.contains(5);
            }

            if(src == 7){
                if(dest == 1) return used.contains(4);
                if(dest == 3) return used.contains(5);
                if(dest == 9) return used.contains(8);
            }

            if(src == 8){
                if(dest == 2) return used.contains(5);
            }

            if(src == 9){
                if(dest == 1) return used.contains(5);
                if(dest == 3) return used.contains(6);
                if(dest == 7) return used.contains(8);
            }

            return true;
        }
    }

}
