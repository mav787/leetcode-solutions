package Z2025.T10_99;

import java.util.*;

public class T13 {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(i == s.length() - 1){
                res += map.get(c);
            }
            else{
                char next = s.charAt(i + 1);
                if(map.get(c) < map.get(next)){
                    res -= map.get(c);
                }
                else{
                    res += map.get(c);
                }
            }
        }

        return res;
    }
}
