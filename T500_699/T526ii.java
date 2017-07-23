package T500_699;

public class T526ii {
	int res = 0;
    public int countArrangement(int N) {
        if(N <= 0)
            return 0;
        perm(N, 0, new boolean[N]);
        return res;
    }
    
    private void perm(int n, int pos, boolean[] used){
        if(pos == n){
            res++;
            return;
        }
        
        for(int i = 1; i <= n; i++){
            if(used[i - 1])
                continue;
            if((pos + 1) % i == 0 || i % (pos + 1) == 0){
                used[i - 1] = true;
                perm(n, pos + 1, used);
                used[i - 1] = false;
            }
        }
        return;
    }
}
