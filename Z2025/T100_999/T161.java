package Z2025.T100_999;

public class T161 {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null){
            return false;
        }

        int m = s.length(), n = t.length();
        if(m > n){
            return isOneEditDistance(t, s);
        }


        // m <= n
        for(int i = 0; i < m; i++){
            if(s.charAt(i) == t.charAt(i)){
                continue;
            }
            else{
                if(m == n){
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                else if(m == n - 1){
                    return s.substring(i).equals(t.substring(i + 1));
                }
                else{
                    return false;
                }
            }
        }

        return n == m + 1;
    }
}
