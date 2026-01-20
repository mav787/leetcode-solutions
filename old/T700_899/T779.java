package old.T700_899;

public class T779 {
	public int kthGrammar(int N, int K) {
        if(N == 1) return 0;
        if(kthGrammar(N - 1, (K - 1) / 2 + 1) == 0){
            if(K % 2 == 0) return 1;
            else return 0;
        }
        else{
            if(K % 2 == 0) return 0;
            else return 1;
        }
    }
}
