package Z2025.T100_999;

import java.util.*;

public class T311 {

    class Solution {
        public int[][] multiply(int[][] mat1, int[][] mat2) {
            int a = mat1.length;
            int b = mat1[0].length;

            int c = mat2.length;
            int d = mat2[0].length;

            // b == c


            int[][] res = new int[a][d];

            for(int i = 0; i < a; i++){
                for(int k = 0; k < b; k++){
                    if(mat1[i][k] == 0){
                        continue;
                    }

                    for(int j = 0; j < d; j++){
                        res[i][j] += mat1[i][k] * mat2[k][j];
                    }
                }
            }

            return res;
        }
    }
}
