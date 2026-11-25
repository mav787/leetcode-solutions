package Z2025.T100_999;

import java.util.*;

public class T412 {
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> res = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                if(i % 3 == 0 && i % 5 == 0){
                    res.add("FizzBuzz");
                }
                else if(i % 3 == 0){
                    res.add("Fizz");
                }
                else if(i % 5 == 0){
                    res.add("Buzz");
                }
                else{
                    res.add(i + "");
                }
            }
            return res;
        }
    }

}
