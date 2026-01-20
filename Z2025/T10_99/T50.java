package Z2025.T10_99;

public class T50 {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }

        if(n == Integer.MIN_VALUE){
            return myPow(x, n + 1) * x;
        }
        if(n < 0){
            return myPow(1/x, -n);
        }

        if(n == 1){
            return x;       // base case
        }

        if(n % 2 == 0){
            return myPow(x * x, n / 2);
        }
        else{
            return myPow(x * x, n / 2) * x;
        }
    }
}
