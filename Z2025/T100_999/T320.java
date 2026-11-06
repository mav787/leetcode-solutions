package Z2025.T100_999;

import java.util.*;

public class T320 {
    class Solution {
        public List<String> generateAbbreviations(String word) {
            List<String> res = new ArrayList<>();
            helper(res, word, new StringBuilder(), 0, 0);
            return res;
        }

        private void helper(List<String> res, String word, StringBuilder sb, int index, int abbrCount){
            if(index == word.length()){
                if(abbrCount != 0){
                    sb.append(abbrCount);
                }

                res.add(sb.toString());
                return;
            }


            int len = sb.length();
            helper(res, word, sb, index + 1, abbrCount + 1);
            sb.setLength(len);


            if(abbrCount != 0){
                sb.append(abbrCount);
            }

            sb.append(word.charAt(index));
            helper(res, word, sb, index + 1, 0);
            // sb.setLength(len);
        }
    }

}
