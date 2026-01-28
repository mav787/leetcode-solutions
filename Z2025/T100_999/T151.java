package Z2025.T100_999;

public class T151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        if(s == null || s.isEmpty()){
            return sb.toString();
        }

        String[] sa = s.trim().split(" ");
        for(int i = sa.length - 1; i >= 0; i--){
            if(sa[i].isEmpty()){
                continue;
            }
            sb.append(sa[i].trim());
            if(i != 0){
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
