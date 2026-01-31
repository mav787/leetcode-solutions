package Z2025.T100_999;

public class T190 {
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            res <<= 1;
            res += n % 2;
            n >>>= 1;
        }

        return res;
    }
}
