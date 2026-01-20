package Z2025.T10_99;

public class T43 {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "";
        int m = num1.length(), n = num2.length();
        int[] arr = new int[m + n];

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                int product = digit1 * digit2;
                int sum = product + arr[i + j + 1];

                arr[i + j + 1] = sum % 10;
                arr[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < arr.length; i++){
            if(sb.length() == 0 && arr[i] == 0){
                continue;
            }

            sb.append(arr[i]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
