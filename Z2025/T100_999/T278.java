package Z2025.T100_999;

import java.util.*;

public abstract class T278 {
    public int firstBadVersion(int n) {
        if(n <= 1){
            return 1;
        }

        int left = 1, right = n;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)){
                right = mid;
            }
            else{
                left = mid;
            }
        }

        if(isBadVersion(left)){
            return left;
        }
        return right;
    }

    abstract boolean isBadVersion(int version);
}
