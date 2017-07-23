package T100_199;
import java.util.*;

public class T166 {
	public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0)
            return "";
        if(numerator == 0)
            return "0";
        long num = (long)numerator, deno = (long)denominator;
        boolean isNegative = (num > 0) ^ (denominator > 0);
        StringBuilder sb = new StringBuilder();
        if(isNegative)
            sb.append("-");
        num = Math.abs(num);
        deno = Math.abs(deno);
        sb.append(String.valueOf(num / deno));
        long mod = num % deno;
        if(mod == 0)
            return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(mod, sb.length());
        while(mod != 0){
            mod *= 10;
            long digit = mod / deno;
            sb.append(digit);
            mod %= deno;
            if(map.containsKey(mod)){
                sb.insert(map.get(mod), "(");
                sb.append(")");
                return sb.toString();
            }
            map.put(mod, sb.length());
        }
        return sb.toString();
    }
}
