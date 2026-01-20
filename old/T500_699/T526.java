package old.T500_699;

public class T526 {
int count = 0;
    
    public int countArrangement(int N) {
        if(N <= 0)
            return 0;
        perm(N, N, new boolean[N + 1]);
        return count;
    }
    
    private void perm(int n, int pos, boolean[] used){
        if(pos < 1){
            count++;
            return;
        }
        for(int i = n; i >= 1; i--){
            if(used[i])
                continue;
            if(pos % i == 0 || i % pos == 0){
                used[i] = true;
                perm(n, pos - 1, used);
                used[i] = false;
            }
        }
    }
}
