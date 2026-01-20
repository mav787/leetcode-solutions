package old.T500_699;
import java.util.*;

public class T621ii {
	public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int max = map[map.length - 1] - 1, idle = max * n;
        for (int i = map.length  - 2; i >= 0 && map[i] > 0; i--) {
            idle -= Math.min(map[i], max);
        }
        return Math.max(tasks.length, tasks.length + idle);
    }
}
