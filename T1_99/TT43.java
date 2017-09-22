package T1_99;

public class TT43 {
	public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "";
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int digit1 = num1.charAt(i) - '0', digit2 = num2.charAt(j) - '0';
                int product = digit1 * digit2;
                
                int sum = product + res[i + j + 1];
                res[i + j + 1] = (res[i + j + 1] + product) % 10;   // sum % 10
                res[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();   
        for(int i : res){
            if(!(sb.length() == 0 && i == 0)) {
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
