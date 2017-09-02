package FaceBook;

public class TT43 {
	public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "0";
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = product + res[i + j + 1];
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length; i++) {
            if(!(sb.length() == 0 && res[i] == 0)) 
                sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
