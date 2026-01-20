package old.T1_99;

public class TT43My {
	public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "";
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int temp = res[i + j + 1];
                int unit = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j)) + temp;
                res[i + j + 1] = unit % 10;
                res[i + j] += unit / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < res.length && res[i] == 0) i++;
        for(; i < res.length; i++){
            sb.append(res[i]);
        }
        if(sb.length() == 0) return "0";
        return sb.toString();
    }
}
