package old.T300_499;
import java.util.*;
public class T455 {
	public int findContentChildren(int[] g, int[] s) {
        if(g == null || g.length == 0 || s == null || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        
        int res = 0, i = 0, j = 0;
        while(i < g.length && j < s.length){
            if(g[i] <= s[j]){
                res++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return res;
    }
}
