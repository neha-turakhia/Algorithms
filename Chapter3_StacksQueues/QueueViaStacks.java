package Chapter3_StacksQueues;

import Utils.PrintUtil;

import java.util.Scanner;
import java.util.Stack;

public class QueueViaStacks {

    /**
     * CTCI 3.4  Queue Via Stacks : Implement a MyQueue Class which implements a queue using 2 stacks.
     *
     * Solution : Implemented a queue using 2 java stacks
     * *AMORTIZED* Time Complexity - O(1) for all enque,deque, empty, peek
     * Space Complexity - O(N) for both stacks together where N is the number of elements enqueued
     **/
    public static void main(String[] args) {
        //Let us assume the queue to be implemented is an integer queue

        Scanner scanner = new Scanner(System.in);
        int option =0;
        System.out.println("Queue Via Stacks");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Peek");
        System.out.println("4. Print Queue");
        MyQueue mq = new MyQueue();
        do {
            System.out.println("Enter your choice");
            option = scanner.nextInt();

            switch (option) {
                case 1: int value = scanner.nextInt();
                        mq.enqueue(value);
                break;
                case 2: try {
                    System.out.println(mq.dequeue());
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
                case 3: try {
                    System.out.println(mq.peek());
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
                case 4:
                    if(!mq.empty()) {
                        PrintUtil.printJavaStack(mq.s2);
                        PrintUtil.printJavaStack(mq.s1);
                    }
             }
        }while(option <= 4);
    }
}

class MyQueue {
    Stack<Integer> s1 ; //enqueue into this stack
    Stack<Integer> s2 ; //dequeue from this stack

    MyQueue() {
        s1 = new Stack<>(); //enqueue into this stack
        s2 = new Stack<>(); //dequeue from this stack
    }
    public void enqueue(int value) {
        this.s1.push(value);
    }
    public int dequeue() throws Exception{
        if(this.empty()) new Exception("Empty Queue!!");
        if(!this.s2.empty()) {
            return this.s2.pop();
        }else{
            this.shiftToStack2();
            PrintUtil.printJavaStack(this.s2);
            return this.s2.pop();
        }
    }

    public int peek() throws Exception{
        if(this.empty()) new Exception("Empty Queue!!");
        if(!this.s2.empty()) {
            return this.s2.peek();
        }else{
            this.shiftToStack2();
            return this.s2.peek();
        }
    }

    public boolean empty() {
        return this.s1.empty() && this.s2.empty();
    }


    private void shiftToStack2() {
        if(this.s1.empty()) return;
        while(!this.s1.empty()) {
            this.s2.push(this.s1.pop());
        }
    }
}