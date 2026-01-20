package old.T200_299;
import java.util.*;

public class T291 {
	public boolean wordPatternMatch(String pattern, String str) {
        String[] map = new String[26]; // mapping of characters 'a' - 'z'
        HashSet<String> set = new HashSet<>(); // mapped result of 'a' - 'z'
        return wordPatternMatch(pattern, str, map, set, 0, str.length()-1, 0, pattern.length()-1);
    }
    private boolean wordPatternMatch(String pattern, String str, String[] map, 
                                     HashSet<String> set, int start, int end, int startP, int endP) {
        if(startP==endP+1 && start==end+1) return true; // both pattern and str are exhausted
        if((startP>endP && start<=end) || (startP<endP && start>end)) return false; // either of pattern or str is exhausted

        char ch = pattern.charAt(startP);
        String matched = map[ch-'a'];
        if(matched!=null) { // ch is already mapped, then continue
            int count = matched.length();
            // substring equals previously mapped string
            return start+count<=end+1 && matched.equals(str.substring(start, start+count)) 
                    && wordPatternMatch(pattern, str, map, set, start+matched.length(), end, startP+1, endP); // moving forward
        }
        else {
            int endPoint = end;
            for(int i=endP; i>startP; i--) {
                endPoint -= map[pattern.charAt(i)-'a']==null ? 1 : map[pattern.charAt(i)-'a'].length();
            }
            for(int i=start; i<=endPoint; i++) { // try every possible mapping, from 1 character to the end
                matched = str.substring(start, i+1);
                if(set.contains(matched)) continue; // different pattern cannot map to same substring

                map[ch-'a'] = matched; // move forward, add corresponding mapping and set content
                set.add(matched);

                if(wordPatternMatch(pattern, str, map, set, i+1, end, startP+1, endP)) return true;

                else { // backtracking, remove corresponding mapping and set content
                    map[ch-'a'] = null;
                    set.remove(matched);
                }
            }
        }
        return false; // exhausted
    }
}
