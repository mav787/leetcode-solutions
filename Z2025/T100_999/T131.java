package Z2025.T100_999;
import java.util.*;

public class T131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }

        boolean[][] dp = getFact(s);
        backtrack(res, s, dp, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<String>> res, String s, boolean[][] dp, int index, List<String> list){
        if(index == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = index + 1; i <= s.length(); i++){
            if(dp[index][i - 1]){
                list.add(s.substring(index, i));
                backtrack(res, s, dp, i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean[][] getFact(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i = 0; i < n; i++){
            dp[i][i] = true;
            for(int j = 1; i - j >= 0 && i + j < n; j++){
                if(s.charAt(i - j) == s.charAt(i + j)){
                    dp[i - j][i + j] = true;
                }
                else{
                    break;
                }
            }
            if(i + 1 < n && s.charAt(i) == s.charAt(i + 1)){
                dp[i][i + 1] = true;
                for(int j = 1; i - j >= 0 && i + j + 1 < n; j++){
                    if(s.charAt(i - j) == s.charAt(i + 1 + j)){
                        dp[i - j][i + 1 + j] = true;
                    }
                    else{
                        break;
                    }
                }
            }
        }

        return dp;
    }
}
