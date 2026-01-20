package old.G_Salesforce.T1_9;

public class T6 {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows <= 1){
            return s;
        }

        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i = 0; i < sbs.length; i++){
            sbs[i] = new StringBuilder();
        }

        int index = 0;
        int inc = -1;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            sbs[index].append(c);
            if(index == 0 || index == sbs.length - 1){
                inc = -inc;
            }
            index += inc;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < sbs.length; i++){
            sb.append(sbs[i]);
        }

        return sb.toString();
    }
}
