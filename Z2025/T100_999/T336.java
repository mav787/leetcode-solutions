package Z2025.T100_999;

import java.util.*;

public class T336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }

        for(int i = 0; i < words.length; i++){
            String word = words[i];

            for(int j = 0; j <= word.length(); j++){
                String left = word.substring(0, j);
                String right = word.substring(j);

                if(isPalindrome(left)){
                    // palindrome = key + left + right
                    String key = new StringBuilder(right).reverse().toString();

                    if(map.containsKey(key)){
                        int value = map.get(key);

                        if(value != i){
                            List<Integer> pair = new ArrayList<>();
                            // first key, then i
                            pair.add(value);
                            pair.add(i);
                            res.add(pair);
                        }
                    }
                }

                if(j != word.length() && isPalindrome(right)){
                    // palindrome = left + right + key
                    String key = new StringBuilder(left).reverse().toString();

                    if(map.containsKey(key)){
                        int value = map.get(key);

                        if(value != i){
                            List<Integer> pair = new ArrayList<>();
                            // first i, then key
                            pair.add(i);
                            pair.add(value);
                            res.add(pair);
                        }
                    }
                }
            }
        }

        return res;
    }

    private boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
