package Z2025.T100_999;

import java.util.*;

public class T415 {
    class Solution {
        public String addStrings(String num1, String num2) {
            num1 = new StringBuilder(num1).reverse().toString();
            num2 = new StringBuilder(num2).reverse().toString();

            StringBuilder sb = new StringBuilder();
            int i = 0, j = 0;
            int carry = 0;

            while(i < num1.length() || j < num2.length()){
                int i1 = i < num1.length() ? num1.charAt(i) - '0' : 0;
                int i2 = j < num2.length() ? num2.charAt(i) - '0' : 0;
                int sum = i1 + i2 + carry;
                sb.append(sum % 10);
                carry = sum / 10;

                i++;
                j++;
            }

            if(carry != 0){
                sb.append(carry);
            }

            return sb.reverse().toString();
        }
    }

}
