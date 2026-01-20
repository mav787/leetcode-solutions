package Z2025.T10_99;

public class T66 {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return new int[]{0};
        }

        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        if(carry == 0){
            return digits;
        }
        else{
            int[] res = new int[digits.length + 1];
            res[0] = carry;
            for(int i = 1; i < res.length; i++){
                res[i] = digits[i - 1];
            }
            return res;
        }
    }
}
