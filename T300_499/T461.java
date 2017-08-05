package T300_499;

public class T461 {
	public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
	
	public int hammingDistance2(int x, int y) {
        int res = 0;
        int xor = x ^ y;
        for(int i = 0; i < 32; i++){
            res += (xor >> i ) & 1;    
        }
        return res;
    }
}
