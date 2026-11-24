package Z2025.T100_999;

import java.util.*;

public class T405 {
    class Solution {
        public String toHex(int num) {
            if (num == 0) {
                return "0";
            }

            char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            StringBuilder sb = new StringBuilder();
            while (num != 0) {
                int index = num & 0b1111;
                sb.insert(0, map[index]);
                num = num >>> 4;
            }
            return sb.toString();
        }
    }
}
