package T1_99;

public class TT67 {
	public String addBinary(String a, String b) {
        if(a == null || b == null)
            return "";
        int alen = a.length(), blen = b.length();
        if(alen < blen)
            return addBinary(b, a);
        StringBuilder sb = new StringBuilder(a).reverse();
        a = sb.toString();
        sb = new StringBuilder(b).reverse();
        b = sb.toString();
        // alen >= blen
        sb = new StringBuilder();
        int carry = 0;
        for(int i = 0; i < alen; i++){
            int adigit = a.charAt(i) - '0';
            int bdigit = i < blen ? b.charAt(i) - '0' : 0;
            
            int sum = adigit + bdigit + carry;
            int digit = sum % 2;
            carry = sum / 2;
            
            sb.append(digit);
        }
        
        if(carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
