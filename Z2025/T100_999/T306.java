package Z2025.T100_999;

import java.util.*;

public class T306 {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        for (int i = 1; i <= n / 2; i++) {
            // String a = s[0, i - 1]
            if (num.charAt(0) == '0' && i > 1) {
                break;
            }

            for (int j = i + 1; j < n; j++) {
                // String b = s[i, j - 1]
                if (num.charAt(i) == '0' && j - 1 > i) {
                    break;
                }

                if (check(num, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(String s, int start, int mid, int end) {
        String a = s.substring(start, mid);
        String b = s.substring(mid, end);

        while (end < s.length()) {
            String sum = add(a, b);

            if (!s.startsWith(sum, end)) {
                return false;
            }

            end += sum.length();
            a = b;
            b = sum;
        }

        return true;
    }

    private String add(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }

}
