package Z2025.T100_999;

public class T171 {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for(char c : columnTitle.toCharArray()){
            res = res * 26;
            res += c - 'A' + 1;
        }

        return res;
    }
}
