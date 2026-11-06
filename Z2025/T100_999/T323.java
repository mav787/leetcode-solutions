package Z2025.T100_999;

import java.util.*;

public class T323 {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for(int i = 0; i < n; i++){
            roots[i] = i;
        }

        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];

            union(a, b, roots);
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(find(i, roots));
        }

        return set.size();
    }

    private int find(int a, int[] roots){
        if (a != roots[a]) {
            roots[a] = find(roots[a], roots);
        }
        return roots[a];
    }

    private void union(int a, int b, int[] roots){
        int rootA = find(a, roots);
        int rootB = find(b, roots);

        if (rootA != rootB) {
            roots[rootA] = rootB;
        }
    }
}
