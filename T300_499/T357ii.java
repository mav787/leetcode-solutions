package T300_499;

public class T357ii {
	public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int res = 10;
        int prev = 9;
        int rest = 9;
        for(int i = 2; i <= n && rest > 0; i++){
            int curr = prev * rest;
            rest--;
            res += curr;
            prev = curr;
        }
        return res;
    }
}
