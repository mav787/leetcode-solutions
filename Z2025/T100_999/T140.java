package Z2025.T100_999;
import java.util.*;

public class T140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);

        if(s == null || s.length() == 0 || set.isEmpty()){
            return res;
        }

        helper(res, s, set, new StringBuilder(), 0);
        return res;
    }

    private void helper(List<String> res, String s, Set<String> set, StringBuilder sb, int index){
        if(index == s.length()){
            sb.setLength(sb.length() - 1);
            res.add(sb.toString());
            return;
        }

        for(int i = index + 1; i <= s.length(); i++){
            String sub = s.substring(index, i);
            if(set.contains(sub)){
                int len = sb.length();
                sb.append(sub).append(" ");
                helper(res, s, set, sb, i);
                sb.setLength(len);
            }
        }
    }
}
