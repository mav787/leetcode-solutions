package Z2025.T100_999;

public class T402 {
    class Solution {
        public String removeKdigits(String num, int k) {
            StringBuilder sb = new StringBuilder();

            for(char c : num.toCharArray()){
                while(k > 0 && !sb.isEmpty() && c < sb.charAt(sb.length() - 1)){
                    sb.setLength(sb.length() - 1);
                    k--;
                }

                sb.append(c);
            }


            sb.setLength(sb.length() - k);
            String res = sb.toString();
            int i = 0;
            while(i < res.length() && res.charAt(i) == '0'){
                i++;
            }

            return res.substring(i).isEmpty()? "0" : res.substring(i);
        }
    }
}
