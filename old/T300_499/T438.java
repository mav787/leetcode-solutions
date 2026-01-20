package old.T300_499;
import java.util.*;
public class T438 {
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] dict = new int[256];
        for (int i = 0; i < p.length(); i++) {
            dict[p.charAt(i)]++;
        }
        int left = 0, right = 0, count = 0;
        while (right < s.length()) {
            if (dict[s.charAt(right)] > 0) {
                count++;
            }
            dict[s.charAt(right)]--;
            right++;
            while (count == p.length()) {
                if (right - left == p.length()) {
                    res.add(left);
                }
                if (dict[s.charAt(left)] >= 0) {
                    count--;
                }
                dict[s.charAt(left)]++;
                left++;
            }
        }
        return res;
    }
}
