package T500_699;

public class T647 {
	public int countSubstrings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res += extend(s, i, i);
            res += extend(s, i, i + 1);
        }
        return res;
    }
    
    private int extend(String s, int start, int end){
        int res = 0;
        int left = start, right = end;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            res++;
        }
        return res;
    }
}
