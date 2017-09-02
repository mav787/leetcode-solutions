package FaceBook;

public class TT50My {
	public double myPow(double x, int n) {
		if(x == 0) return 0;
        if(n == 0) return 1;
        
        if(n > 0){
            if(n % 2 == 0) return myPow(x * x, n / 2);
            else return x * myPow(x * x, n / 2);
        }
        else{
            if(n % 2 == 0) return myPow(x * x, n / 2);
            else return 1 / x * myPow(x * x, n / 2);
        }
    }
}
