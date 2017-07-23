package T1_99;

public class TT76 {
	public String minWindow(String s, String t) {
        if(s == null || s.isEmpty() || t == null || t.isEmpty()) 
            return "";
        int i = 0, j = 0;
        int[] tmap=new int[256];
        int[] smap=new int[256];
        for(int k = 0; k < t.length(); k++){
            tmap[t.charAt(k)]++;
        }
        int found = 0;
        int length = Integer.MAX_VALUE;
        String res = "";
        while(j < s.length()){
            if(found < t.length()){
                if(tmap[s.charAt(j)] > 0){
                    smap[s.charAt(j)]++;
                    if(smap[s.charAt(j)] <= tmap[s.charAt(j)]){
                        found++;
                    }
                }
                j++;
            }
            while(found == t.length()){
                if(j - i < length){
                    length = j - i;
                    res = s.substring(i,j);
                }
                if(tmap[s.charAt(i)] > 0){
                    smap[s.charAt(i)]--;
                    if(smap[s.charAt(i)] < tmap[s.charAt(i)]){
                        found--;
                    }
                }
                i++;
            }
        }
        return res;
    }
}
