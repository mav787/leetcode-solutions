package T200_299;

public class T231Trick {
	public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
        return (n & (n - 1)) == 0;
    }
}
