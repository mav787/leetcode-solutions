package Z2025.T100_999;

import java.util.*;

public class T372 {
    class Solution {
        int mod = 1337;

        public int rec(int x, int p) {
            if (p == 0) return 1;
            if (p == 1) return x % mod;

            x %= mod;

            long halfpow = rec(x, p / 2);
            long halfpowsq = (halfpow * halfpow) % mod;

            if (p % 2 != 0) {
                return (int) ((x * halfpowsq) % mod);
            }

            return (int) halfpowsq;
        }

        public int superPow(int a, int[] b) {
            int num = 1;
            a %= mod;

            for (int i = 0; i < b.length; i++) {
                num = rec(num, 10);

                int curr = rec(a, b[i]);

                num = (int) ((long) num * curr % mod);
            }

            return num;
        }
    }

}
