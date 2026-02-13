package Z2025.T100_999;
import java.util.*;

public class T244 {
    Map<String, List<Integer>> map;

    public T244(String[] wordsDict) {
        this.map = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++){
            String s = wordsDict[i];
            List<Integer> list = map.getOrDefault(s, new ArrayList<>());
            list.add(i);
            map.put(s, list);
        }
    }

    public int shortest(String word1, String word2) {
        List l1 = map.get(word1), l2 = map.get(word2);
        return helper(l1, l2);
    }


    private int helper(List<Integer> l1, List<Integer> l2){
        int res = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while(i < l1.size() && j < l2.size()){
            int i1 = l1.get(i);
            int i2 = l2.get(j);

            if(i1 < i2){
                res = Math.min(res, i2 - i1);
                i++;
            }
            else{
                res = Math.min(res, i1 - i2);
                j++;
            }
        }
        return res;
    }
}
