package Z2025.T100_999;

public class T243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int seen1 = -1, seen2 = -1;
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < wordsDict.length; i++){
            String s = wordsDict[i];
            if(s.equals(word1)){
                seen1 = i;
                if(seen2 != -1){
                    res = Math.min(res, i - seen2);
                }
            }
            else if(s.equals(word2)){
                seen2 = i;
                if(seen1 != -1){
                    res = Math.min(res, i - seen1);
                }
            }
        }

        return res;
    }
}
