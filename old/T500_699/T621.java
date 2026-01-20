package old.T500_699;
import java.util.*;

public class T621 {
	public int leastInterval(char[] tasks, int n) {
        int[] dict = new int[26];
        for(char c : tasks){
            dict[c - 'A']++;
        }
        Arrays.sort(dict);
        int i = dict.length - 1;
        while(i >= 0 && dict[i] == dict[dict.length - 1]){
            i--;
        }

        return Math.max(tasks.length, (dict[dict.length - 1] - 1) * (n + 1) + dict.length - i - 1);
    }
}
