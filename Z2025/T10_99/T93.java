package Z2025.T10_99;
import java.util.*;

public class T93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        helper(res, s, 0, 0, new StringBuilder());
        return res;
    }

    private void helper(List<String> res, String s, int index, int commas, StringBuilder sb){
        if(index == s.length() && commas == 4){
            sb.setLength(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        if(index == s.length() || commas > 3){
            return;
        }

        for(int i = 1; i <= 3; i++){
            if(index + i > s.length()){
                continue;
            }

            String digits = s.substring(index, index + i);
            int value = Integer.valueOf(digits);
            if(value >= 0 && value <= 255){
                if(value == 0 && i != 1){
                    continue;
                }
                if(value != 0 && s.charAt(index) == '0'){
                    continue;
                }

                int len = sb.length();
                sb.append(digits);
                sb.append(".");

                helper(res, s, index + i, commas + 1, sb);
                sb.setLength(len);
            }
        }
    }
}
