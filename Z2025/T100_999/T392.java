package Z2025.T100_999;

import java.util.*;

public class T392 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            if(s.length() > t.length()){
                return false;
            }

            int i = 0, j = 0;

            while(i < s.length() && j < t.length()){
                if(s.charAt(i) == t.charAt(j)){
                    i++;
                    j++;
                }
                else{
                    j++;
                }
            }

            return i == s.length();
        }
    }

}
