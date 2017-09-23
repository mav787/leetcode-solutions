package C_FaceBook;

public class TT69 {
	public int mySqrt(int x) {
        if(x < 0) return -1;
        long left = 0, right = x;
        
        while(left + 1 < right){
            long mid = left + (right - left) / 2;
            if(mid * mid == x) return (int)mid;
            else if(mid * mid < x) left = mid;
            else right = mid;
        }
        if(right * right <= x) return (int)right;
        return (int)left;
    }
}
