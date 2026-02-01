package Z2025.T100_999;

public class T204 {
    public int countPrimes(int n) {
        if(n <= 2){
            return 0;
        }

        // [0, n - 1]
        boolean[] ba = new boolean[n];

        int res = 0;
        for(int i = 2; i < ba.length; i++){
            if(!ba[i]){
                res++;
                for(int j = 2; j * i < n; j++){
                    ba[i * j] = true;
                }
            }
        }
        return res;
    }
}
