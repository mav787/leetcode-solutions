package old.T100_199;
import java.util.*;

public class T140 {
	public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();  
        if(s == null || s.length() == 0) return res;
        if(wordBreakcheck(s, set)) helper(s,set,0,"",res);  
        return res;
    }
    
    public boolean wordBreakcheck(String s, Set<String> dict) {
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = i - 1; j >= 0; j--){
                if(res[j] && dict.contains(s.substring(j, i))){
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
 
    private void helper(String s, Set<String> dict, int start, String tmp, List<String> res){  
        if (start >= s.length()) {
            res.add(tmp);
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (dict.contains(sb.toString())) {
                String newString = new String();
                if (tmp.length() > 0) newString = tmp + " " + sb.toString();
                else newString = sb.toString();
                helper(s, dict, i + 1, newString, res);
            }
        }
    }
}
