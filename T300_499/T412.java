package T300_499;
import java.util.*;

public class T412 {
	public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        if(n < 1){
            return res;
        }
        for(int i = 1; i <= n; i++){
            if(i % 15 == 0){
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
