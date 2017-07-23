package FaceBook;

import java.util.*;

public class TT49 {
	public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return res;
        }
        
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String keystr = String.valueOf(arr);
            if(!map.containsKey(keystr)){
                map.put(keystr, new ArrayList<String>());
            }
            ArrayList<String> list = map.get(keystr);
            list.add(s);
        }
        res.addAll(map.values());
        return res;
    }
}
