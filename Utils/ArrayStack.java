package Utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack {
//Assumption - Implementation done for a Stack implemented as an integer array, list is implemented to avoid memory allocation issues

    int top;
    List<Integer> stack;

    ArrayStack() {
        top = -1;
        stack = new ArrayList<>();
    }

    public int push(int value) {
        stack.add(value);
        top = value;
        return top;
    }

    public int pop() {
        if(!this.empty()) {
            int val = stack.remove(stack.size()-1);
            top = stack.get(stack.size()-1);
            return val;
        }else {
            return top;
        }
    }

    public boolean empty() {
        return stack.size() == 0;
    }

    public int peek() {
        return top;
    }
}