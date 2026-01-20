package old.T200_299;
import java.util.*;

public class T246My {
	public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() < 1)
            return true;
        Set<Character> set = new HashSet<>();
        set.add('0');
        set.add('1');
        set.add('8');
        int left = 0, right = num.length() - 1;
        while(left <= right){
            if(set.contains(num.charAt(left)) && num.charAt(left) == num.charAt(right)){
                left++;
                right--;
            }
            else{
                char lc = num.charAt(left);
                char rc = num.charAt(right);
                if(lc == '6' && rc == '9'){
                    left++;
                    right--;
                }
                else if(lc == '9' && rc == '6'){
                    left++;
                    right--;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
