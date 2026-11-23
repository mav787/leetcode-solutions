package Z2026;

import java.util.*;

public class T2469 {
    class Solution {
        public double[] convertTemperature(double celsius) {
            double[] res = new double[2];
            res[0] = celsius + 273.15;
            res[1] = celsius * 1.80 + 32.00;
            return res;
        }
    }

}
