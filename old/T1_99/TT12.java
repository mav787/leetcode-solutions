package old.T1_99;

public class TT12 {
	public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[] sa = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] vals = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        for(int i = 0; i < vals.length; i++){
            while(num >= vals[i]){
                sb.append(sa[i]);
                num -= vals[i];
            }
        }
        return sb.toString();
    }
}
