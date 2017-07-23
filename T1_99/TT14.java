package T1_99;

public class TT14 {
	public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if(strs == null) return null;
        if(strs.length == 0) return "";
        
        // get the minimum length
        int minLength = Integer.MAX_VALUE;
        for(String s : strs){
            minLength = Math.min(minLength, s.length());
        }
        
        // compare and construct
        for(int i = 0; i < minLength; i++){
            char c = strs[0].charAt(i);
            for(String s : strs){
                if(s.charAt(i) != c){
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
