package old.G_Salesforce.T100_999;
import java.util.*;

public class T735 {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length == 0){
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids){
            if(stack.isEmpty()){
                stack.push(asteroid);
                continue;
            }

            if(asteroid < 0 && stack.peek() > 0){
                // > <
                boolean lives = true;
                while(!stack.isEmpty() && stack.peek() > 0){
                    int sum = stack.peek() + asteroid;
                    if(sum < 0){
                        stack.pop();
                    }
                    else if(sum == 0){
                        stack.pop();
                        lives = false;
                        break;
                    }
                    else{
                        lives = false;
                        break;
                    }
                }

                if(lives){
                    stack.push(asteroid);
                }
            }
            else{
                // > > , < < , < >
                stack.push(asteroid);
            }
        }

        int[] res = new int[stack.size()];

        for(int i = res.length - 1; i >= 0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}
