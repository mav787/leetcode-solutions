package Z2025.T100_999;

import java.util.*;

public class T390 {
    public int lastRemaining(int n) {
        int head = 1;               // First remaining number
        int step = 1;               // Gap between consecutive numbers
        int remaining = n;          // Number of remaining elements
        boolean leftToRight = true; // Current elimination direction

        while(remaining > 1){
            // Left to right: the first element is always removed.
            // Right to left: the first element is removed only if
            // the number of remaining elements is odd.
            if(leftToRight || remaining % 2 == 1){
                head += step;
            }

            // Keep floor(remaining / 2) elements after each round.
            remaining /= 2;

            // The gap between surviving elements doubles.
            step *= 2;

            // Alternate the elimination direction.
            leftToRight = !leftToRight;
        }

        return head;
    }
}
