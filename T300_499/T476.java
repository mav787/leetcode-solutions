package T300_499;

public class T476 {
	public int findComplement(int num) {
        if(num == 0)
            return 1;
        int res = 0;
        int shift = 0;
        while(num != 0){
            int bit = num & 1;
            // flip
            bit = bit ^ 1;
            res |= (bit << shift);
            shift++;
            num >>= 1;
        }
        return res;
    }
}
