package Z2025.T100_999;

import java.util.*;

public class T406 {

    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            List<int[]> list = new ArrayList<>();

            // Process taller people first.
            // For equal heights, process smaller k first.
            Arrays.sort(people, (a, b) ->
                    b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]
            );

            for (int[] person : people) {
                // Everyone already in the queue is at least as tall.
                // Therefore, inserting at index k guarantees exactly
                // k taller-or-equal people appear before this person.
                //
                // Shorter people inserted later won't affect the k
                // values of previously placed taller people.
                list.add(person[1], person);
            }

            return list.toArray(new int[people.length][]);
        }
    }


}
