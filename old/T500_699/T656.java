package old.T500_699;
import java.util.*;

public class T656 {
	private boolean[][] connect;

    public List<Integer> cheapestJump(int[] A, int B) {
        long[] cost = new long[A.length];
        long INF = Long.MAX_VALUE / 10;
        for (int i = 1; i < A.length; i++) {
            cost[i] = INF;
            if (A[i] != -1) {
                for (int j = Math.max(0, i - B); j < i; j++) {
                    cost[i] = Math.min(cost[i], cost[j] + A[i]);
                }
            }
        }
        if (cost[A.length - 1] >= INF) {
            return Collections.emptyList();
        }
        connect = new boolean[A.length][A.length];
        boolean[] done = new boolean[A.length];
        dfs(A, B, cost, A.length - 1, done);
        List<Integer> answer = new ArrayList<>();
        int cur = 0;
        answer.add(cur + 1);
        while (cur < A.length - 1) {
            for (int next = cur + 1; next <= cur + B && next < A.length; next++) {
                if (connect[cur][next]) {
                    cur = next;
                    answer.add(cur + 1);
                    break;
                }
            }
        }
        return answer;
    }

    private void dfs(int[] A, int B, long[] cost, int i, boolean[] done) {
        if (i == 0) {
            return;
        }
        if (done[i]) {
            return;
        }
        if (A[i] != -1) {
            for (int j = Math.max(0, i - B); j < i; j++) {
                if (cost[i] == cost[j] + A[i]) {
                    connect[j][i] = true;
                    dfs(A, B, cost, j, done);
                }
            }
        }
        done[i] = true;
    }

}
