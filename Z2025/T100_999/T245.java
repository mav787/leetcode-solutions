package Z2025.T100_999;
import java.util.*;

public class T245 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++){
            String s = wordsDict[i];
            List<Integer> list = map.getOrDefault(s, new ArrayList<>());
            list.add(i);
            map.put(s, list);
        }

        if(word1.equals(word2)){
            List<Integer> list = map.get(word1);
            for(int i = 0; i < list.size() - 1; i++){
                res = Math.min(res, list.get(i + 1) - list.get(i));
            }

            return res;
        }

        else{
            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);

            int i = 0, j = 0;
            while(i < l1.size() && j < l2.size()){
                if(l1.get(i) <= l2.get(j)){
                    res = Math.min(res, l2.get(j) - l1.get(i));
                    i++;
                }
                else{
                    res = Math.min(res, l1.get(i) - l2.get(j));
                    j++;
                }
            }

            return res;
        }
    }
}
