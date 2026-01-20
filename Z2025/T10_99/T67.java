package Z2025.T10_99;

public class T67 {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0){
            return b;
        }
        if(b == null || b.length() == 0){
            return a;
        }

        StringBuilder sa = new StringBuilder(a);
        sa = sa.reverse();

        StringBuilder sb = new StringBuilder(b);
        sb = sb.reverse();

        StringBuilder res = new StringBuilder();
        int carry = 0;

        for(int i = 0; i < Math.max(sa.length(), sb.length()); i++){
            int ia = i < sa.length() ? sa.charAt(i) - '0' : 0;
            int ib = i < sb.length() ? sb.charAt(i) - '0' : 0;

            int sum = ia + ib + carry;
            res.append(sum % 2);
            carry = sum / 2;
        }

        if(carry != 0){
            res.append(carry);
        }

        return res.reverse().toString();
    }
}
