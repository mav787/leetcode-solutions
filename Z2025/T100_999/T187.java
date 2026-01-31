package Z2025.T100_999;
import java.util.*;

public class T187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() < 10){
            return res;
        }

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i <= s.length() - 10; i++){
            String key = s.substring(i, i + 10);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for(String key : map.keySet()){
            if(map.get(key) > 1){
                res.add(key);
            }
        }

        return res;
    }
}
