package old.T300_499;

public class T319 {
	
//	factor of 6: 1,2,3,6
//	factor of 7: 1,7
//	factor of 9: 1,3,9
//
//	so all number have even number of factors except square number(e.g: factor of 9:1,3,9).
//	square number must turn on because of odd number of factors(9: turn on at 1st, off at 3rd, on at 9th)
//	other number must turn off(6: turn on at 1st, off at 2nd, on at 3rd, off at 6th)
//	so we only need to compute the number of square number less equal than n
	public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
