package Z2025.T10_99;
import java.util.*;


public class T49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);

            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(s);
            map.put(key, list);
        }

        for(String key : map.keySet()){
            res.add(map.get(key));
        }

        return res;
    }
}
