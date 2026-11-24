package Z2025.T100_999;

import java.util.*;

public class T408 {
    class Solution {
        public boolean validWordAbbreviation(String word, String abbr) {
            int i = 0, j = 0;
            while(i < word.length() && j < abbr.length()){
                if(word.charAt(i) == abbr.charAt(j)){
                    i++;
                    j++;
                }
                else if(abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9'){
                    int num = 0;
                    while(j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9'){
                        num = num * 10 + abbr.charAt(j) - '0';
                        j++;
                        if(num == 0){
                            return false;
                        }

                    }

                    i += num;
                }
                else{
                    return false;
                }
            }

            return i == word.length() && j == abbr.length();
        }
    }
}
