package old.T300_499;

public class T367 {
	public boolean isPerfectSquare(int num) {
        if(num < 0) return false;
        long input = num;
        long left = 0, right = input;
        while(left + 1 < right){
            long mid = left + (right - left) / 2;
            if(mid * mid < input){
                left = mid;
            }
            else if(mid * mid == input){
                return true;
            }
            else{
                right = mid;
            }
        }
        return left * left == input || right * right == input;
    }
}
