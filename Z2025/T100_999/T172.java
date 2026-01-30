package Z2025.T100_999;

public class T172 {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n != 0){
            res += n / 5;
            n /= 5;
        }

        return res;
    }
}
