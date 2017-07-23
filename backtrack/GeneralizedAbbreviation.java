package backtrack;
import java.util.*;

public class GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word){
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), word, 0, 0);
        return ans;
    }

    // i is the current position
    // k is the count of consecutive abbreviated characters
    private void backtrack(List<String> ans, StringBuilder builder, String word, int i, int k){
        int len = builder.length(); // keep the length of builder
        if(i == word.length()){
            if (k != 0)
                builder.append(k); // append the last k if non zero
            ans.add(builder.toString());
            
            // StringBuilder is an object....
            builder.setLength(len); // reset builder to the original state
            return;
        } 
        // the branch that word.charAt(i) is abbreviated
        backtrack(ans, builder, word, i + 1, k + 1);

        // the branch that word.charAt(i) is kept
        if (k != 0) 
            builder.append(k);
        builder.append(word.charAt(i));
        backtrack(ans, builder, word, i + 1, 0);
            
        builder.setLength(len); // reset builder to the original state
    }
}
