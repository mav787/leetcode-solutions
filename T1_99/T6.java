package T1_99;

public class T6 {
	public String convert(String s, int numRows) {
        if(s == null || s.length() == 0){
            return "";
        }
        if(numRows < 2){
            return s;
        }
        StringBuilder[] sbarr = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            sbarr[i] = new StringBuilder();
        }
        
        int index = 0, len = s.length();
        while(index < len){
            for(int i = 0; i < numRows && index < len; i++){			// vertically down
                sbarr[i].append(s.charAt(index));
                index++;
            }
            for(int j = numRows - 2; j > 0 && index < len; j--){		// obliquely up
                sbarr[j].append(s.charAt(index));
                index++;
            }
        }
        
        for(int i = 1; i < numRows; i++){
            sbarr[0].append(sbarr[i]);
        }
        return sbarr[0].toString();
    }
}
