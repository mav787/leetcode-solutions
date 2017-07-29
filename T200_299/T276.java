package T200_299;

public class T276 {
	public int numWays(int n, int k) {
        if(n == 0) 
            return 0;
        else if(n == 1) 
            return k;
        int currDiff = k * (k - 1);
        int currSame = k;
        for(int i = 2; i < n; i++) {
        	int former = currDiff + currSame;
            int formerDiff = currDiff;
            currDiff = former * (k - 1);
            currSame = formerDiff;
        }
        int curr = currDiff + currSame;
        return curr;
    }
}
