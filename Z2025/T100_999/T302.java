package Z2025.T100_999;

import java.util.*;

public class T302 {
    class Solution {
        int xmin, xmax;
        int ymin, ymax;
        public int minArea(char[][] image, int x, int y) {
            xmin = x;
            xmax = x;

            ymin = y;
            ymax = y;

            helper(image, x, y);
            return (xmax - xmin + 1) * (ymax - ymin + 1);
        }

        private void helper(char[][] image, int x, int y){
            if (x < 0 || x >= image.length){
                return;
            }
            if(y < 0 || y >= image[0].length){
                return;
            }

            if(image[x][y] == '0'){
                return;
            }

            image[x][y] = '0';

            xmin = Math.min(xmin, x);
            xmax = Math.max(xmax, x);
            ymin = Math.min(ymin, y);
            ymax = Math.max(ymax, y);

            helper(image, x - 1, y);
            helper(image, x + 1, y);
            helper(image, x, y - 1);
            helper(image, x, y + 1);
        }
    }
}
