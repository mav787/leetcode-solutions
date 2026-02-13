package Z2025.T100_999;
import java.util.*;

public class T232 {
    Stack<Integer> s1, s2;

    public T232() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if(!s2.isEmpty()){
            return s2.pop();
        }

        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        return s2.pop();
    }

    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }

        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
