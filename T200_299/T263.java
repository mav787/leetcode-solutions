package T200_299;

public class T263 {
	public boolean isUgly(int num) {
        if(num <= 0)
            return false;
        if(num == 1)
            return true;
        return (num % 2 == 0 && isUgly(num / 2)) || (num % 3 == 0 && isUgly(num / 3)) || (num % 5 == 0 && isUgly(num / 5));
    }
}
