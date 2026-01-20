package old.T100_199;

import java.util.*;

public class T155 {
	Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public T155() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }
    
    public void pop() {
        int elem = stack.pop();
        if(minStack.peek() == elem){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
