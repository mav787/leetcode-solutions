package Z2025.T100_999;

import java.util.*;

public class T316 {

    class Solution {
        public String removeDuplicateLetters(String s) {
            int[] count = new int[26];
            boolean[] visited = new boolean[26];

            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int index = c - 'a';

                count[index]--;

                if (visited[index]) {
                    continue;
                }

                while (sb.length() > 0
                        && sb.charAt(sb.length() - 1) > c
                        && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {

                    char last = sb.charAt(sb.length() - 1);

                    sb.setLength(sb.length() - 1);
                    visited[last - 'a'] = false;
                }

                sb.append(c);
                visited[index] = true;
            }

            return sb.toString();
        }
    }


}
