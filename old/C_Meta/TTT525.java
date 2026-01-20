package old.C_Meta;
import java.util.*;
public class TTT525 {
	public int findMaxLength(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0;
        
        for(int i = 0; i < arr.length; i++){
            sum += arr[i] == 0 ? -1 : 1;
            if(map.containsKey(sum)){
                res = Math.max(res, i - map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }
        return res;
    }
}
