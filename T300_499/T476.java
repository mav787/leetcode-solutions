package T300_499;

public class T476 {
	public int findComplement(int num) {
        if(num == 0){
            return 1;
        }
        int res = 0;
        int power = 0;
        while(num != 0){
            int bit = num % 2;
            res = (1 - bit) * (int)Math.pow(2, power) + res;
            power++;
            num = num / 2;
        }
        return res;
    }
}
