package Z2025.T100_999;

import java.util.*;

public class T274 {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }

        // 1. sort
        Arrays.sort(citations);

        int res = 0;

        // 2. scan
        for(int i = citations.length - 1; i >= 0; i--){
            if(citations[i] >= citations.length - i){
                res++;
            }
        }

        return res;
    }
}
