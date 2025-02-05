package C_Meta;

public class TTT639 {
	public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        
        long[] dp = new long[len + 1];
        dp[0] = 1;
        if(s.charAt(0) == '0'){
            return 0;
        }
        dp[1] = (s.charAt(0) == '*') ? 9 : 1;
        
        for(int i = 2; i <= len; i++){
            char first = s.charAt(i - 2);
            char second = s.charAt(i - 1);

            if(second == '*'){              // single digit
                dp[i] += 9 * dp[i - 1];
            }else if(second > '0'){
                dp[i] += dp[i - 1];
            }

            if(first == '*'){
                if(second == '*'){              // 11 - 19, 21 - 26   // * from 1 to 9
                    dp[i] += 15 * dp[i - 2];
                }else if(second <= '6'){           // 1x or 2x
                    dp[i] += 2 * dp[i - 2];
                }else{
                    dp[i] += dp[i - 2];             // 1x
                }
            }else if(first == '1' || first == '2'){
                if(second == '*'){
                    if(first == '1'){               // 1x
                       dp[i] += 9 * dp[i - 2]; 
                    }else{              // first = '2' 2x
                       dp[i] += 6 * dp[i - 2]; 
                    }
                }else if(((first - '0') * 10 + (second - '0')) <= 26 ){
                    dp[i] += dp[i - 2];    
                }
            }

            dp[i] %= 1000000007;
        }
        return (int)dp[len];
    }
}
