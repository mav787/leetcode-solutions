package T1_99;

public class TT66 {
	public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0)
            return new int[0];
        int len = digits.length;
        int[] res = new int[len];
        int sum = digits[len - 1] + 1;
        res[len - 1] = sum % 10;
        int carry = sum / 10;
        int curr = len - 2;
        while(carry != 0 && curr >= 0){
            res[curr] = (digits[curr] + carry) % 10;
            carry = (digits[curr] + carry) / 10;
            curr--;
        }
        while(curr >= 0){
            res[curr] = digits[curr];
            curr--;
        }
        if(carry == 0)
            return res;
        else{
            int[] newres = new int[len + 1];
            newres[0] = 1;
            return newres;
        }
    }
}
