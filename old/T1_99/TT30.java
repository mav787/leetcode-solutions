package old.T1_99;
import java.util.*;

public class TT30 {
	// My idea is pretty simple. Just build a map for the words and their relative count in L.
	//Then we traverse through S to check whether there is a match.
	
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || words == null || words.length == 0) 
        	return res;
        int len = words[0].length(); // length of each word
        
        Map<String, Integer> map = new HashMap<String, Integer>(); // map for words
        for (String w : words) 
        	map.put(w, map.getOrDefault(w, 0) + 1);
        
        for (int i = 0; i <= s.length() - len * words.length; i++) {		// starting points
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < words.length; j++) { // check if match
                String str = s.substring(i + j * len, i + j * len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) 
                    	copy.remove(str);
                    else 
                    	copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else {
                	break; // not in words
                }
            }
        }
        return res;
    }
}
