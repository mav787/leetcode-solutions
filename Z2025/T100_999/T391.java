package Z2025.T100_999;

import java.util.*;

public class T391 {
    class Solution {
        public boolean isRectangleCover(int[][] rectangles) {
            long sum = 0;

            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;

            Set<String> corners = new HashSet<>();

            for(int[] rect : rectangles){
                int x1 = rect[0], y1 = rect[1];
                int x2 = rect[2], y2 = rect[3];

                // Calculate the total area of all small rectangles.
                sum += (long)(x2 - x1) * (y2 - y1);

                // Update the bounding rectangle.
                minX = Math.min(minX, x1);
                minY = Math.min(minY, y1);
                maxX = Math.max(maxX, x2);
                maxY = Math.max(maxY, y2);

                // Toggle each corner based on its occurrence parity.
                toggle(corners, x1, y1);
                toggle(corners, x1, y2);
                toggle(corners, x2, y1);
                toggle(corners, x2, y2);
            }

            // The total area must equal the bounding rectangle's area.
            long area = (long)(maxX - minX) * (maxY - minY);
            if(sum != area){
                return false;
            }

            // Only the four outer corners should remain.
            if(corners.size() != 4){
                return false;
            }

            return corners.contains(minX + "," + minY)
                    && corners.contains(minX + "," + maxY)
                    && corners.contains(maxX + "," + minY)
                    && corners.contains(maxX + "," + maxY);
        }

        private void toggle(Set<String> corners, int x, int y) {
            String key = x + "," + y;

            // Even occurrences cancel out; odd occurrences remain.
            if(!corners.add(key)){
                corners.remove(key);
            }
        }
    }

}
