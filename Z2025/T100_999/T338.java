package Z2025.T100_999;

import java.util.*;

public class T338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for(int i = 1; i <= num; i++){
            if(i % 2 == 0){
                res[i] = res[i / 2];
            }
            else{
                res[i] = 1 + res[i / 2];
            }
        }

        return res;
    }
}
