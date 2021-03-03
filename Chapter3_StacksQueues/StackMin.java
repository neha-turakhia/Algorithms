package Chapter3_StacksQueues;

import Utils.PrintUtil;

import java.util.Scanner;
import java.util.Stack;

public class StackMin {

    /**
     * CTCI 3.2 StackMin: How would you design a stack which, in addition to push and pop, has a function min
     *  which returns the minimum element? Push, pop and min should all operate in O(1) time.
     *
     *  Solution : Implement a class MinStack while extends java.util.Stack, create a min stack object inside that class
     *             since we need to know the min value at any point of time in O(1), Hence we maintain 2 stacks.
     *  Time Complexity : O(1) for push(), pop() and min()
     *  Space Complexity : upper bound to O(N) -- N is the size of the stack
     **/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option=0;
        MinStack stack = new MinStack();
        System.out.println("Enter an option to proceed");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Peek");
        System.out.println("4. Min");
        System.out.println("5. Print Stack");
        System.out.println("6. Exit");

        do {
            option = scanner.nextInt();

            switch (option) {
                case 1: int val = scanner.nextInt();
                    stack.push(val);
                 break;
                case 2: stack.pop();
                break;
                case 3: System.out.println("Stack Top : "+stack.peek());
                break;
                case 4: System.out.println("Stack Min :"+stack.min());
                break;
                case 5:
                    PrintUtil.printStack(stack);
            }
            System.out.println("Enter an option to proceed");
        }while (option > 0 && option <6);

    }
}

class MinStack extends Stack<Integer>{

    Stack<Integer> minStack = new Stack<>();
    @Override
    public Integer push(Integer item) {
        if((minStack.empty()) || (!minStack.empty() && minStack.peek() >= item)){
            minStack.push(item);
        }
        return super.push(item);
    }

    @Override
    public synchronized Integer pop() {
        int top =  !super.empty() ? super.pop() : Integer.MIN_VALUE;
        if(top !=  Integer.MIN_VALUE && !minStack.empty() && top == minStack.peek()) {
             minStack.pop();
        }
        return top;
    }

    @Override
    public boolean empty() {
        return minStack.size() == 0 ? true : false;
    }

    @Override
    public synchronized Integer peek() {
        return super.peek();
    }

    public Integer min() {
        return minStack.peek();
    }
}