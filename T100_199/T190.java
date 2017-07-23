package T100_199;

public class T190 {
	public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            int bit = (n >> i) & 1;
            res = (res << 1) + bit;
        }
        return res;
    }
}
