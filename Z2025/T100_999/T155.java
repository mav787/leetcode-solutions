package Z2025.T100_999;
import java.util.*;

public class T155 {
    Stack<Integer> stack;
    Stack<Integer> min;

    public T155() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(min.isEmpty() || val <= min.peek()){
            min.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if(!min.isEmpty() && val == min.peek()){
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
