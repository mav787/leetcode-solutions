package T1_99;

public class TT70 {
	public int climbStairs(int n) {
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        int prepre = 1, pre = 2;
        int res = 0;
        for(int i = 2; i < n; i++){
            res = prepre + pre;
            prepre = pre;
            pre = res;
        }
        return res;
    }
}
