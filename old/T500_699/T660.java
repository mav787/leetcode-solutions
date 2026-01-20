package old.T500_699;

public class T660 {
	public int newInteger(int n) {
        int res = 0;
        int pow = 1;
        while (n > 0) {
            res += pow * (n % 9);
            n = n / 9;
            pow = pow * 10;
        }
        return res;
    }
}
