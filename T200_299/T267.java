package T200_299;
import java.util.*;

public class T267 {
	public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0)
            return res;
        int[] dict = new int[256];
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            int index = (int)(s.charAt(i));
            dict[index]++;
        }
        
        int singleIndex = -1;
        for(int i = 0; i < dict.length; i++){
            if(dict[i] % 2 != 0){
                if(count > 0)
                    return res;
                count++;
                singleIndex = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if(count > 0){
            sb.append((char)singleIndex);
            dict[singleIndex]--;
        }
        
        backtrack(res, sb, dict, s);
        return res;
    }
    
    
    private void backtrack(List<String> res, StringBuilder sb, int[] dict, String s){
        if(sb.length() == s.length()){
            res.add(sb.toString());
            return;
        }
        
        for(int i = 0; i < dict.length; i++){
            if(dict[i] <= 0)
                continue;
            
            dict[i] -= 2;
            sb.insert(0, (char)i);
            sb.append((char)i);
            
            backtrack(res, sb, dict, s);
            
            dict[i] += 2;
            sb.deleteCharAt(0);
            sb.setLength(sb.length() - 1);
        }
    }
}
