package T500_699;

public class T649 {
	public String predictPartyVictory(String senate) {
        int len = senate.length();
        boolean Rsurvive = true;
        boolean Dsurvive = true;
        boolean disabled[] = new boolean[len];
        int R = 0;
        int D = 0;
        
        while (Rsurvive && Dsurvive) {
            Rsurvive = false;
            Dsurvive = false;
            
            for (int i = 0 ; i < len; i++) {
                if (!disabled[i]) {
                    char c = senate.charAt(i);
                    if ( c == 'R') {
                        if (D > 0) {
                            D--;
                            disabled[i] = true;
                        } else {
                            R++;
                            Rsurvive = true;
                        }
                    } else {
                        if (R > 0) {
                            R--;
                            disabled[i] = true;
                        } else {
                            D++;
                            Dsurvive = true;
                                
                        }
                    }
                
                }
            }
        }
        if (Rsurvive) return "Radiant";
        return "Dire";
    }
}
