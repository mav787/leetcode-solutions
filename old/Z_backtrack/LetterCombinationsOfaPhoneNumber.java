package old.Z_backtrack;

import java.util.*;
//import java.util.List;

public class LetterCombinationsOfaPhoneNumber {
	public List<String> letterCombinations(String digits) {
        String[] keyboard = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits == null || digits.length() == 0)
            return new ArrayList<String>();
        List<String> res = new ArrayList<>();
        // extra space for char array... 
        // not necessary
        char[] arr = digits.toCharArray();
        int[] index = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            index[i] = (int)(arr[i] - '0');
        }
        
        computeCombinations(res, new StringBuilder(), index, keyboard, 0);
        return res;
    }
    
    private void computeCombinations(List<String> res, StringBuilder sb, int[] index, String[] keyboard, int start){
        int len = sb.length();
        if(sb.length() == index.length){
            res.add(sb.toString());
            return;
        }
        
        for(int i = start; i < index.length; i++){
            String letters = keyboard[index[i]];
            for(int j = 0; j < letters.length(); j++){
                sb.append(letters.charAt(j));
                computeCombinations(res, sb, index, keyboard, i + 1);
                sb.setLength(len);
            }
        }
    }
}
