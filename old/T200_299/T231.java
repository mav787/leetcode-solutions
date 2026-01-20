package old.T200_299;

public class T231 {
	public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
        if(n == 1)
            return true;
        return n % 2 == 0 && isPowerOfTwo(n / 2);
    }
}
