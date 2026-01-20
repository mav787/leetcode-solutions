package old.G_Salesforce.T1000_9999;
import java.util.*;

public class T1456 {
    public int maxVowels(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int left = 0, right = 0;
        int res = 0;
        int count = 0;

        for(right = 0; right < s.length(); right++){
            if(set.contains(s.charAt(right))){
                count++;
            }
            while(right - left + 1 > k){
                if(set.contains(s.charAt(left))){
                    count--;
                }
                left++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
