package FaceBook;

public class T67ii {
	public String addBinary(String a, String b) {
        if(a == null) return b;
        if(b == null) return a;
        StringBuilder sb = new StringBuilder();
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        
        int carry = 0;
        for(int i = 0; i < Math.max(a.length(), b.length()); i++){
            int aa = i < a.length() ? a.charAt(i) - '0' : 0;
            int bb = i < b.length() ? b.charAt(i) - '0' : 0;
            
            int sum = aa + bb + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        if(carry != 0){
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}
