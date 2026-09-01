package Z2025.T100_999;
import java.util.*;

public class T267 {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int[] counts = new int[26];
        for(char c : s.toCharArray()){
            counts[c - 'a']++;
        }


        String mid = "";
        int odds = 0;
        for(int i = 0; i < counts.length; i++){
            if(counts[i] % 2 != 0){
                odds++;
                mid = String.valueOf((char)(i + 'a'));
            }
            if(odds > 1){
                return res;
            }
        }

        backtrack(counts, res, mid, new StringBuilder(), s.length());
        return res;
    }

    private void backtrack(int[] counts, List<String> res, String mid, StringBuilder sb, int length){
        if(sb.length() == length / 2){
            String s = sb.toString() + mid + new StringBuilder(sb).reverse().toString();
            res.add(s);
            return;
        }

        for(int i = 0; i < counts.length; i++){
            if(counts[i] >= 2){

                sb.append(String.valueOf((char)(i + 'a')));
                counts[i] -= 2;

                backtrack(counts, res, mid, sb, length);

                sb.setLength(sb.length() - 1);
                counts[i] += 2;
            }
        }
    }
}
