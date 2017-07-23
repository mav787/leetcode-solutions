package T200_299;

public class T258 {
	public int addDigits(int num) {
        return num == 0 ? 0 : (num % 9 == 0 ? 9 : ( num % 9));
    }
}
