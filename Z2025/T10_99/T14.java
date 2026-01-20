package Z2025.T10_99;

public class T14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if(strs == null || strs.length == 0){
            return sb.toString();
        }

        String s = strs[0];

        for(int i = 0; i < s.length(); i++){
            for(int j = 1; j < strs.length; j++){
                if(i >= strs[j].length()){
                    return sb.toString();
                }

                if(s.charAt(i) != strs[j].charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
