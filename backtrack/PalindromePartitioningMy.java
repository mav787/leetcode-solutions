package backtrack;
import java.util.*;

public class PalindromePartitioningMy {
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        if(s == null || s.length() == 0){
            res.add(part);
            return res;
        }
        
        backtrack(res, part, s, 0);
        return res;
    }
    
    private void backtrack(List<List<String>> res, List<String> part, String s, int start){
        if(start == s.length()){
            res.add(new ArrayList<String>(part));
            return;
        }
        for(int i = start + 1; i <= s.length(); i++){
            String substring = s.substring(start, i);
            if(!isPalindrome(substring)){
                continue;
            }
            else{
                part.add(substring);
                backtrack(res, part, s, i);
                part.remove(part.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
