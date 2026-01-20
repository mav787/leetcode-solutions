package old.T100_199;
import java.util.*;

public class T187My {
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() <= 10)
            return res;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i <= s.length() - 10; i++){
            String sub = s.substring(i, i + 10);
            if(!map.containsKey(sub)){
                map.put(sub, 1);
            }
            else{
                map.put(sub, map.get(sub) + 1);
            }
        }
        
        for(String str : map.keySet()){
            if(map.get(str) > 1){
                res.add(str);
            }
        }
        return res;
    }
}
