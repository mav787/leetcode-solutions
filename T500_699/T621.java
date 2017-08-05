package T500_699;
import java.util.*;

public class T621 {
	public int leastInterval(char[] tasks, int n) {
        int[] dict = new int[26];
        for(char c : tasks){
            dict[c - 'A']++;
        }
        Arrays.sort(dict);
        int i = 25;
        while(i >= 0 && dict[i] == dict[25]){
            i--;
        }

        return Math.max(tasks.length, (dict[25] - 1) * (n + 1) + 25 - i);
    }
}
