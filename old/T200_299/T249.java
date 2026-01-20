package old.T200_299;
import java.util.*;

public class T249 {
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if(strings == null || strings.length == 0)
            return res;
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings){
            StringBuilder sb = new StringBuilder();
            int offset = s.charAt(0) - 'a';
            for(int i = 0; i < s.length(); i++){
                char newchar = (char)(s.charAt(i) - offset);
                if(newchar < 'a')
                    newchar += 26;
                sb.append(newchar);
            }
            String keyStr = sb.toString();
            if(!map.containsKey(keyStr)){
                map.put(keyStr, new ArrayList<String>());
            }
            List<String> list = map.get(keyStr);
            list.add(s);
        }
        
        for(String s : map.keySet()){
            res.add(map.get(s));
        }
        return res;
    }
}
