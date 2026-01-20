package old.C_Meta;

public class TT76 {
	public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) return "";
        int len = Integer.MAX_VALUE;
        String res = "";
        
        int[] smap = new int[256];
        int[] tmap = new int[256];
        
        for(int i = 0; i < t.length(); i++){
            tmap[t.charAt(i)]++;
        }
        
        int left = 0, right = 0;
        int count = 0;
        while(right < s.length()){
            if(count < t.length()){
                smap[s.charAt(right)]++;
                if(smap[s.charAt(right)] <= tmap[s.charAt(right)]){
                    count++;
                }
                right++;
            }
            
            while(count == t.length()){
                // still legal
                if(right - left < len){
                    len = right - left;
                    res = s.substring(left, right);
                }
                smap[s.charAt(left)]--;
                if(smap[s.charAt(left)] < tmap[s.charAt(left)]){
                    count--;
                }
                left++;
            }
        }
        return res;
    }
}
