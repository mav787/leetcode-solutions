package FaceBook;

public class TT50 {
	public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        
        if(n > 0){
            double inter = myPow(x, n / 2);
            if(n % 2 == 0) return inter * inter;
            return x * inter * inter;
        }
        else{
            return 1 / x * myPow(1 / x, -(n + 1));
        }
    }
	
//	public double myPow(double x, int n) {
//		if(x == 0) return 0;
//        if(n == 0) return 1;
//        
//        if(n > 0){
//            if(n % 2 == 0) return myPow(x * x, n / 2);
//            else return x * myPow(x * x, n / 2);
//        }
//        else{
//            if(n % 2 == 0) return myPow(x * x, n / 2);
//            else return 1 / x * myPow(x * x, n / 2);
//        }
//    }
}
