package C_FaceBook;

public class TT67 {
	public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        
        StringBuilder sa = new StringBuilder(a).reverse();
        StringBuilder sb = new StringBuilder(b).reverse();
        
        StringBuilder res = new StringBuilder();
        int carry = 0;
        
        for(int i = 0; i < Math.max(sa.length(), sb.length()); i++){
            int aval = i < sa.length() ? sa.charAt(i) - '0' : 0;
            int bval = i < sb.length() ? sb.charAt(i) - '0' : 0;
            
            int sum = aval + bval + carry;
            res.append(sum % 2);
            carry = sum / 2;
        }
        
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}
