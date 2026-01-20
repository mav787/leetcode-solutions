package old.T100_199;
import java.util.*;

public class T140TLE {
	public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(s == null || wordDict == null || wordDict.size() == 0)
            return res;
        Set<String> dict = new HashSet<>(wordDict);
        backtrack(res, new StringBuilder(), s, dict, 0);
        return res;
    }
    
    private void backtrack(List<String> res, StringBuilder sb, String s, Set<String> dict, int start){
        
        if(start == s.length()){
            res.add(sb.toString());
            return;
        }
        
        int len = sb.length();
        for(int i = start; i <= s.length(); i++){
            String item = s.substring(start, i);
            if(dict.contains(item)){
                // backtrack
                if(len == 0)
                    sb.append(item);
                else
                    sb.append(" ").append(item);
                backtrack(res, sb, s, dict, i);
                
                sb.setLength(len);
            }
        }
    }
}
