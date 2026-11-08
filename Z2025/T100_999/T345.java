package Z2025.T100_999;

import java.util.*;

public class T345 {
    public String reverseVowels(String s) {

        char[] ca = s.toCharArray();
        int left = 0, right = ca.length - 1;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U');


        while(left <= right){
            char lc = ca[left], rc = ca[right];
            if(!set.contains(lc)){
                left++;
            }
            else if(!set.contains(rc)){
                right--;
            }
            else{
                char c = ca[left];
                ca[left] = ca[right];
                ca[right] = c;

                left++;
                right--;
            }
        }

        return String.valueOf(ca);
    }

}
