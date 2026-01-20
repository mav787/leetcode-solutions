package Z2025.T1_9;

public class T6 {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows < 2){
            return s;
        }

        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i = 0; i < sbs.length; i++){
            sbs[i] = new StringBuilder();
        }
        int inc = 1;
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            sbs[index].append(s.charAt(i));
            index += inc;
            if(index == 0 || index == numRows - 1){
                inc = -inc;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sbs.length; i++){
            sb.append(sbs[i].toString());
        }

        return sb.toString();
    }
}
