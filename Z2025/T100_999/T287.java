package Z2025.T100_999;

import java.util.*;

public class T287 {
    public int findDuplicate(int[] nums) {

        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];

        tortoise = nums[tortoise];
        hare = nums[nums[hare]];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }

        // Find the "entrance" to the cycle.
        tortoise = nums[0];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}
