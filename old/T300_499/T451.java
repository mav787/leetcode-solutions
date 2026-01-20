package old.T300_499;

public class T451 {
	public String frequencySort(String s) {
        if(s == null || s.length() <= 2){
            return s;
        }
        
        int[] cnt = new int[256];
        int max = 0;
        for(char c: s.toCharArray()){
            cnt[c]++;
            max = Math.max(max,cnt[c]);
        }
        
        String[] bucket = new String[max + 1];
        // join the chars with same cnt into same bucket
        for(int i = 0; i < cnt.length; i++){
            String charsComb = bucket[cnt[i]];
            if(cnt[i] > 0){
                bucket[cnt[i]] = charsComb == null? "" + (char)i : charsComb + (char)i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = max; i >= 0; i--){
            String charsComb = bucket[i];
            if(charsComb != null){
                for(char c : charsComb.toCharArray()){
                    for(int j = 0; j < i; j++){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
