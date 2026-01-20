package old.C_Meta.T100_999;
import java.util.*;

public class T528 {
    int[] rollingSum;
    int res;

    public T528(int[] w) {
        rollingSum = new int[w.length];
        res = 0;
        for(int i = 0; i < w.length; i++){
            res += w[i];
            rollingSum[i] = res;
        }
    }

    public int pickIndex() {
        Random random = new Random();
        int target = random.nextInt(res);

        // binary search and return index
        // find smallest index such that rollingSum[i] > target

        int left = 0, right = rollingSum.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(rollingSum[mid] <= target){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        if(rollingSum[left] > target){
            return left;
        }
        else{
            return right;
        }
    }
}
