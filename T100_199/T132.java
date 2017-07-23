package T100_199;

public class T132 {
	public int minCut(String s) {
        char[] ca = s.toCharArray();
        int n = s.length();
        int[] cut = new int[n];
        boolean[][] isPalin = new boolean[n][n];
        
        for(int i = 0; i < n; i++) {
            cut[i] = i;
            for(int j = 0; j <= i; j++) {
                if(ca[j] == ca[i] && (j + 1 > i - 1 || isPalin[j + 1][i - 1])) {
                    isPalin[j][i] = true;  
                    cut[i] = j == 0 ? 0 : Math.min(cut[i], cut[j - 1] + 1);
                }
            }
        }
        return cut[n - 1];
    }
}
