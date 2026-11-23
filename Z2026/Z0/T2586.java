package Z2026;

import java.util.*;

public class T2586 {
    class Solution {
        public int vowelStrings(String[] words, int left, int right) {
            int res = 0;
            Set<Character> set = new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');
            for(int i = left; i <= right; i++){
                if(isVowel(words[i], set)){
                    res++;
                }
            }

            return res;
        }

        private boolean isVowel(String word, Set<Character> set){
            return set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1));
        }

    }

}
