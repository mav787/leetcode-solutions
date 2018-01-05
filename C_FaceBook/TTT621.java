package C_FaceBook;
import java.util.*;

public class TTT621 {
	public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        if(n <= 0) return tasks.length;
        int[] count = new int[26];
        for(char c : tasks){
            count[c - 'A']++;
        }
        Arrays.sort(count);
        int maxGap = count[25] - 1;
        int idle = maxGap * n;
        for(int i = 24; i >= 0 && count[i] > 0; i--){
            idle -= Math.min(count[i], maxGap);
        }
        return Math.max(tasks.length, tasks.length + idle);
    }
}
