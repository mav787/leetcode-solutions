package T100_199;
import java.util.*;

public class T166 {
	public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        
        if(numerator < 0 ^ denominator < 0) sb.append("-");
        
        long numer = (long)Math.abs((long)numerator);
        long deno = (long)Math.abs((long)denominator);
        
        
        long floor = numer / deno;
        sb.append(floor);
        long mod = numer % deno;
        if(mod == 0) return sb.toString();
        sb.append(".");
        
        
        while(mod != 0){
            mod *= 10;
            long digit = mod / deno;
            if(!map.containsKey(mod)){
                sb.append(digit);
                map.put(mod, sb.length() - 1);
                mod = mod % deno;
            }
            else{
                sb.insert(map.get(mod), "(");
                sb.append(")");
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
