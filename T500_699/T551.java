package T500_699;

public class T551 {
	public boolean checkRecord(String s) {
        if(s == null || s.length() < 2){
            return true;
        }
        int countA = 0, countL = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'P')
                countL = 0;
            else if(c == 'A'){
                if(countA >= 1)
                    return false;
                else{
                    countA++;
                    countL = 0;
                }
            }
            else{
                if(i < 2)
                    countL++;
                else{
                    if(countL >= 2)
                        return false;
                    else
                        countL++;
                }
            }
        }
        return true;
    }
}
