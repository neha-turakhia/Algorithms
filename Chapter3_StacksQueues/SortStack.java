package Chapter3_StacksQueues;

import Utils.PrintUtil;

import java.util.Scanner;
import java.util.Stack;

public class SortStack {
    /**
     * CTCI 3.5 Sort Stack : Write a program to sort a stack such that the smallest items are on the top. You can use
     *                      an additional temporary stack, but you may not copy the elements into any other data structure
     *                      (such as an array). The stack support the following operations: pop, peek, and isEmpty.
     *
     *  Approach : Use the build in stack data structure for the main and the temp stack. Implement a MyStack class which overrides
     *             push method. If we tweek out the push method to ensure the stack is sorted the other methods would work fine.
     *             While pushing an element into the stack we compare it with the top , if the top is lesser than the item to be inserted
     *             we need to pop it out and insert it at a position such that the top value is greater or equal to the value to be inserted.
     *             For every value popped out of the main stack we push it into the temp stack and once our incoming value in pushed into
     *             the stack, we pop out elements from the temp stack and push them in the same order.
     *
     * Time Complexity : push - can go upto O(N) if the value to be inserted is the largest value seen so far, in this case we would pop
     *                          out the whole stack to push this value. For smaller values the push operation is much lesser.
     *                   pop, empty, peek - O(1)
     *
     * Space Complexity : O(N) for the temp stack used for `push` operation
     **/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option =0;
        System.out.println("Sorted Stack");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Peek");
        System.out.println("4. Print Stack");
        MyStack myStack = new MyStack();
        do {
            System.out.println("Enter your choice");
            option = scanner.nextInt();

            switch (option) {
                case 1: int value = scanner.nextInt();
                    myStack.push(value);
                    break;
                case 2: try {
                            System.out.println(myStack.pop());
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                break;
                case 3: try {
                            System.out.println(myStack.peek());
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                break;
                case 4: PrintUtil.printJavaStack(myStack);
                break;
            }
        }while(option <= 4);
    }
}

class MyStack extends Stack<Integer> {
    Stack<Integer> temp;
    MyStack() {
        temp = new Stack<Integer>();
    }

    public Integer push(Integer item) {
        int val;
        if(super.empty() || (!super.empty() && super.peek() >= item)) {
            val =  super.push(item);
        }else {
            while(!super.empty() && super.peek()<item) {
                temp.push(super.pop());
            }
            val = super.push(item);
            while(!temp.empty()) {
                super.push(temp.pop());
            }
        }
        return val;
    }

}