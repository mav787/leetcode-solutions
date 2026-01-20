package Z2025.T10_99;

public class T29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negativeCount = 2;
        if (dividend > 0) {
            negativeCount--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negativeCount--;
            divisor = -divisor;
        }

        int res = 0;
        int base = divisor;
        int inc = -1;

        while (base >= Integer.MIN_VALUE / 2 && dividend <= base + base) {
            inc <<= 1;
            base <<= 1;
        }

        while (dividend <= divisor) {
            if (dividend <= base) {
                res += inc;
                dividend -= base;
            }

            base >>= 1;
            inc >>= 1;
        }

        return negativeCount == 1 ? res : -res;
    }
}
