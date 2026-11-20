package Z2025.T100_999;

import java.util.*;

public class T387 {
    public int firstUniqChar(String s) {
        int[] dict = new int[26];
        for(char c : s.toCharArray()){
            dict[c - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(dict[c - 'a'] == 1){
                return i;
            }
        }

        return -1;
    }

}
