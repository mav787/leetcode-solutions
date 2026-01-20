package Z2025.T10_99;

public class T69 {
    public int mySqrt(int x) {
        if(x <= 1){
            return x;
        }

        int left = 1, right = x;

        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(mid < x / mid){
                left = mid;
            }
            else{
                right = mid;
            }
        }

        if(right <= x / right){
            return right;
        }
        return left;
    }
}
