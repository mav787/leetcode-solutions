package C_Meta;

public class TTT278 {
	public int firstBadVersion(int n) {
        if(n <= 1)
            return n;
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
        
        if(isBadVersion(left))
            return left;
        return right;
    }
	
	private boolean isBadVersion(int version){
		return false;
	}
}


