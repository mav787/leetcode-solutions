package Z2025.T10_99;

public class T12 {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[] sa = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] ia = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for(int i = 0; i < sa.length; i++){
            while(num >= ia[i]){
                sb.append(sa[i]);
                num -= ia[i];
            }
        }

        return sb.toString();
    }
}
