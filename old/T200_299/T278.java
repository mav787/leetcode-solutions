package old.T200_299;

public class T278 {
	public int firstBadVersion(int n) {
        if(n < 1)
            return -1;
        int left = 1, right = n;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        if(isBadVersion(left)){
            return left;
        }
        if(isBadVersion(right)){
            return right;
        }
        return -1;
    }
	
	private boolean isBadVersion(int n){
		return false;
	}
}
