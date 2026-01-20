package old.T1_99;

public class TT66ii {
	public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0)
            return new int[0];
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            else{
                digits[i] = 0;
            }
        }
        int[] newres = new int[len + 1];
        newres[0] = 1;
        return newres;
    }
}
