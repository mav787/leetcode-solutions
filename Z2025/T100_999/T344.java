package Z2025.T100_999;

import java.util.*;

public class T344 {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while(left <= right){
            char c = s[left];
            s[left] = s[right];
            s[right] = c;

            left++;
            right--;
        }
    }

}
