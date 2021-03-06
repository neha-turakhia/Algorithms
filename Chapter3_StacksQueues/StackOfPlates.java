package Chapter3_StacksQueues;

import Utils.LinkedStack;
import Utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StackOfPlates {
    /**
     * CTCI 3.3. Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
     * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
     * Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and
     * should create a new stack once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop()
     * should behave identically to a single stack (that is, pop() should return the same values as it would if there were just
     * a single stack).
     *
     *  FOLLOW UP: Implement a function popAt(index) which performs a pop operation on a specific sub-stack
     *
     *  Approach : We use LinkedStack Data structure which is a linked list that behaves like a stack.
     *             Here every operation (push, pop, peek) happened in O(1).
     *             We then create a ArrayList of LinkedStack to store multiple stacks. We have done this since accessing an element at
     *             a particular index is a constant time operation for an array list. This ensure popAt and peekAt also occur at O(1)
     *  Time Complexity - O(1) for push, pop, popAt, peek, peekAt
     *  Space Complexity - O(N*m) - where N is the number of sets which store the stacks and m is the capacity of each stack
     **/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the capacity of the stack");
        int individualStackCapacity = scanner.nextInt();
        SetOfStacks setOfStacks = new SetOfStacks(individualStackCapacity);
        int option=0;
        System.out.println("Enter an option to proceed");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Pop At");
        System.out.println("4. Peek");
        System.out.println("5. Peek At");
        System.out.println("6. Print Stack");
        System.out.println("7. Exit");

        do {
            option = scanner.nextInt();

            switch (option) {
                case 1: int val = scanner.nextInt();
                try {
                    setOfStacks.push(val);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
                case 2:
                    try {
                        setOfStacks.pop();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    int stackIndex = scanner.nextInt();
                    try {
                        setOfStacks.popAt(stackIndex);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Stack Top :"+setOfStacks.peek());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 5:
                     stackIndex = scanner.nextInt();
                    try {
                        System.out.println("Stack Top :"+setOfStacks.peekAt(stackIndex));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                 break;
                case 6: setOfStacks.printStack();
            }
            System.out.println("Enter an option to proceed");
        }while (option > 0 && option <7);
    }
}

class SetOfStacks{
    List<LinkedStack> stackList;
    int allowedCapacity=0;
    SetOfStacks(int individualStackCapacity){
        this.stackList = new ArrayList<LinkedStack>();
        this.allowedCapacity = individualStackCapacity;
    }

    public int push(int value) throws Exception{
        int returnVal = -1;
        if(stackList.size() == 0){
            LinkedStack stack = new LinkedStack(this.allowedCapacity);
            returnVal = stack.push(value);
            stackList.add(stack);
        }else{
            LinkedStack topStack = stackList.get(stackList.size()-1);
            try {
                returnVal = topStack.push(value);
            }catch (Exception e) {
                System.out.println("Stack capacity reached, going to create a new stack");
                LinkedStack stack = new LinkedStack(this.allowedCapacity);
                returnVal = stack.push(value);
                stackList.add(stack);
            }
        }
        return returnVal;
    }

    public int pop() throws Exception{
        int returnVal = -1;
        if(stackList.size() == 0) {
            throw new Exception("Empty Stack");
        }else{
            LinkedStack topStack = stackList.get(stackList.size()-1);
             returnVal = topStack.pop();
             if(topStack.empty()){
                    stackList.remove(stackList.size()-1);
             }
        }
        return returnVal;
    }

    public int popAt(int stackIndex) throws Exception{
        int returnVal = -1;
        if(stackList.size() == 0) {
            throw new Exception("Empty Stack");
        }else{
            LinkedStack topStack = stackList.get(stackIndex-1);
            returnVal = topStack.pop();
            if(topStack.empty()){
                stackList.remove(stackList.size()-1);
            }
        }
        return returnVal;
    }

    public int peek() throws Exception{
        if(stackList.size() == 0) {
            throw new Exception("Empty Stack");
        }else {
            LinkedStack topStack = stackList.get(stackList.size() - 1);
            return topStack.peek();
        }
    }

    public int peekAt(int stackIndex) throws Exception{
        if(stackList.size() == 0) {
            throw new Exception("Empty Stack");
        }else {
            LinkedStack topStack = stackList.get(stackIndex - 1);
            return topStack.peek();
        }
    }

    public void printStack(){
        for(int i=0;i<stackList.size();++i){
            LinkedStack stack = this.stackList.get(i);
            PrintUtil.printLinkedStack(stack);
        }
    }

}