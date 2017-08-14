package T500_699;

public class T507 {
	public boolean checkPerfectNumber(int num) {
        if(num <= 0) return false;
        int res = 0;
        for(int i = 1; i <= Math.sqrt(num); i++){
            if(i * i == num){
                res += i;
            }
            else if(num % i == 0){
                res += i;
                res += num / i;
            }
        }
        res -= num;
        return res == num;
    }
}
