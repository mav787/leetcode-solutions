package Z2025.T100_999;

import java.util.*;

public class T394 {
    class Solution {
        public String decodeString(String s) {
            return helper(s, 0, s.length() - 1);
        }

        private String helper(String s, int left, int right){
            if(left > right){
                return "";
            }

            StringBuilder sb = new StringBuilder();
            for(int i = left; i <= right; i++){
                char c = s.charAt(i);
                if(c >= 'a' && c <= 'z'){
                    sb.append(c);
                }
                else if(c >= '0' && c <= '9'){
                    int num = 0;
                    int j = i;
                    while(s.charAt(j) != '['){
                        num = num * 10 + s.charAt(j) - '0';
                        j++;
                    }

                    // s.charAt(j) == '['

                    int depth = 0;
                    int k = j;
                    for(k = j; k <= right; k++){
                        if(s.charAt(k) == '['){
                            depth++;
                        }
                        else if(s.charAt(k) == ']'){
                            depth--;
                        }

                        if(depth == 0){
                            break;
                        }
                    }

                    // s.charAt(k) == ']'
                    String pattern = helper(s, j + 1, k - 1);
                    for(int m = 0; m < num; m++){
                        sb.append(pattern);
                    }

                    i = k;
                }
            }

            return sb.toString();
        }
    }
}
