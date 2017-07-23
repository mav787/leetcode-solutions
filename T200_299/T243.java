package T200_299;

public class T243 {
	public int shortestDistance(String[] words, String word1, String word2) {
        if(words == null || words.length < 2)
            return Integer.MAX_VALUE;
        int index1 = -1, index2 = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1))
                index1 = i;
            else if(words[i].equals(word2))
                index2 = i;
            if(index1 != -1 && index2 != -1)
                res = Math.min(res, Math.abs(index1 - index2));
        }
        return res;
    }
}
