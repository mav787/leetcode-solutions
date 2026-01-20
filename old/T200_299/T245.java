package old.T200_299;

public class T245 {
	public int shortestWordDistance(String[] words, String word1, String word2) {
        if(words == null || words.length < 1)
            return Integer.MAX_VALUE;
        int index1 = -1, index2 = -1, res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                if(word1.equals(word2)){        // only 1 variable here...
                    if(index1 != -1){
                        res = Math.min(res, i - index1);
                    }
                    index1 = i;
                }
                else{
                    index1 = i;
                    if(index2 != -1)
                        res = Math.min(res, index1 - index2);
                }
            }
            else if(words[i].equals(word2)){
                index2 = i;
                if(index1 != -1)
                    res = Math.min(res, index2 - index1);
            }
        }
        return res;
    }
}
