package G_Salesforce.T100_999;

public class T647 {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res += expand(s, i, i);
            res += expand(s, i, i + 1);
        }

        return res;
    }

    private int expand(String s, int i, int j){
        int count = 0;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
            count++;
        }
        return count;
    }
}
