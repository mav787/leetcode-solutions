package FaceBook;

public class T67 {
	public String addBinary(String a, String b) {
        if(a == null && b == null)
            return null;
        if(a == null || b == null)
            return a == null? b: a;
        StringBuilder sb = new StringBuilder();
        int len1 = a.length(), len2 = b.length();
        if(len1 < len2){
            return addBinary(b, a);
        }
        
        int p1 = len1 - 1, p2 = len2 - 1;
        int sum = 0, digit = 0, carry = 0;
        while(p1 >= 0){
            int d1 = Character.getNumericValue(a.charAt(p1));
            int d2 = p2 >= 0 ? b.charAt(p2) - '0' : 0;
            sum = d1 + d2 + carry;
            digit = sum % 2;
            carry = sum / 2;
            
            sb.insert(0, String.valueOf(digit));
            p1--;
            p2--;
        }
        
        if(carry != 0){
            sb.insert(0, String.valueOf(carry));
        }
        
        return sb.toString();
    }
}
