package Z2025.T100_999;
import java.util.*;

public class T246 {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();

        map.put('1', '1');
        map.put('0', '0');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');

        for(int i = 0; i < num.length(); i++){
            char c1 = num.charAt(i);
            char c2 = num.charAt(num.length() - i - 1);

            if(!map.containsKey(c1) || map.get(c1) != c2){
                return false;
            }
        }

        return true;
    }
}
