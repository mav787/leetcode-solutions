package T100_199;
//import java.util.*;

public class T151 {
	public String reverseWords(String s) {
        if(s == null) return s;
        s = s.trim();
        String[] sa = s.split(" +");
        int left = 0, right = sa.length - 1;
        while(left < right){
            String temp = sa[left];
            sa[left] = sa[right];
            sa[right] = temp;
            
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for(String str : sa){
            sb.append(str).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
