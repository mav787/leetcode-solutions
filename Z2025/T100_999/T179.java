package Z2025.T100_999;
import java.util.*;

public class T179 {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }

        String[] sa = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            sa[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(sa, (a, b) -> (b + a).compareTo((a + b)));

        if(sa[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : sa) {
            sb.append(s);
        }

        return sb.toString();
    }
}
