package Z2025.T100_999;

import java.util.*;

public class T318 {
    public int maxProduct(String[] words) {
        if(words == null || words.length < 2){
            return 0;
        }

        List<int[]> list = new ArrayList<>();
        for(String word : words){
            list.add(transform(word));
        }

        int res = 0;
        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                if(product(list.get(i), list.get(j)) == 0){
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }

        return res;
    }


    private int[] transform(String s){
        int[] res = new int[26];
        for(char c : s.toCharArray()){
            res[c - 'a']++;
        }
        return res;
    }


    private int product(int[] arr1, int[] arr2){
        int res = 0;
        for(int i = 0; i < arr1.length; i++){
            res += arr1[i] * arr2[i];
        }

        return res;
    }

}
