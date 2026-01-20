package old.T200_299;

public class T201 {
	public int rangeBitwiseAnd(int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        int move = 0;
        while(m != n){
            m >>= 1;
            n >>= 1;
            move++;
        }
        return m << move;
    }
}
