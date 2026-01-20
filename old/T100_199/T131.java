package old.T100_199;
import java.util.*;

public class T131 {
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            res.add(new ArrayList<String>());
            return res;
        }
        
        List<String> partition = new ArrayList<>();
        backtrack(res, partition, s, 0);
        return res;
    }
    
    
    private void backtrack(List<List<String>> res, List<String> partition, String s, int start){
        if(start == s.length()){
            res.add(new ArrayList<String>(partition));
            return;
        }
        
        for(int i = start + 1; i <= s.length(); i++){
            String sub = s.substring(start, i);
            if(isPalindrome(sub)){
                partition.add(sub);
                backtrack(res, partition, s, i);
                partition.remove(partition.size() - 1);
            }
        }
    }
    
    
    private boolean isPalindrome(String s){
        if(s == null || s.length() < 2)
            return true;
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
