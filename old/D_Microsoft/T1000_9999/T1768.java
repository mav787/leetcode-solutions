package old.D_Microsoft.T1000_9999;

public class T1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length(), len2 = word2.length();

        int i = 0;
        for(i = 0; i < Math.min(len1, len2); i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        if(i < len1){
            sb.append(word1.substring(i));
        }
        else{
            sb.append(word2.substring(i));
        }

        return sb.toString();
    }
}
