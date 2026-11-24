package Z2025.T100_999;

import java.util.*;

public class T400 {
    class Solution {
        public int findNthDigit(int n) {
            // Group numbers by their digit length:
            // 1-digit: 1-9     -> 9 numbers,   9 digits total
            // 2-digit: 10-99   -> 90 numbers,  180 digits total
            // 3-digit: 100-999 -> 900 numbers, 2700 digits total

            long start = 1;  // First number in the current group: 1, 10, 100, ...
            long count = 9;  // Number of integers in the group: 9, 90, 900, ...
            int digits = 1;  // Digits per integer in the group: 1, 2, 3, ...

            // Skip entire groups until the nth digit falls inside the current group.
            // Example: n = 15
            // Skip 1-digit numbers (9 digits), leaving n = 6.
            // We now need the 6th digit among 10, 11, 12, 13, ...
            while (n > count * digits) {
                n -= count * digits;

                // Move to the next group (1-digit -> 2-digit -> 3-digit).
                digits++;
                start *= 10;
                count *= 10;
            }

            // Find which integer contains the target digit.
            //
            // Each integer occupies 'digits' positions.
            // (n - 1) converts the 1-based position into a 0-based offset.
            //
            // Example: n = 6, digits = 2, start = 10
            // (6 - 1) / 2 = 2, meaning skip 2 complete integers (10 and 11).
            // The target digit is inside 12.
            long num = start + (n - 1) / digits;

            // Find the target digit's 0-based index inside that integer.
            //
            // Example: n = 6, digits = 2
            // (6 - 1) % 2 = 1, meaning the second digit of 12.
            int index = (n - 1) % digits;

            // Convert the integer to a string and extract the target digit.
            // charAt(index) returns a character such as '2'.
            // Subtracting '0' converts it into the integer 2.
            return String.valueOf(num).charAt(index) - '0';
        }
    }

}
