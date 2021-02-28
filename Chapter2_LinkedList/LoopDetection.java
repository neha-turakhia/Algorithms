package Chapter2_LinkedList;

import Utils.LinkedNode;
import Utils.PrintUtil;
import Utils.SinglyLinkedList;

import java.util.Scanner;

public class LoopDetection {
/**
 * CTCI 2.8 Loop Detection : Given a circular linked list, Implement an algorithm that returns the node at the beginning of the loop.
 *
 * DEFINITION : Circular linked list : A (corrupt) linked list in which a node's next pointer pointer points to an earlier node, so
 * as to make a loop in the linked list.
 *
 * INPUT :  A - B - C - D - E - C
 * OUTPUT : C
 *
 * Solution : Solve using 2 pointer technique using fast and slow pointer. Break the loop when both are equal.
 *            Reset the fast pointer to the head of the list and then move both pointers at the same speed by just 1 step.
 *            Both the pointers me at the head of the loop , return this value.
 *
 * Time Complexity :  O(N)
 * Space Complexity : O(1)
 **/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        SinglyLinkedList list = new SinglyLinkedList();

        for(int i=0;i<length;++i){
            int value = scanner.nextInt();
            LinkedNode node = new LinkedNode(value);
            list.insertEnd(node);
        }
        PrintUtil.printLinkedList(list);

        System.out.println("Enter the position where the list loops");
        int pos = scanner.nextInt();

        if(pos > 0 && pos < list.getLength()) {
            LinkedNode node = list.getNodeAtIndex(pos);
            LinkedNode cur = list.getHead().getNext();
            while(cur != null && cur.getNext() != null) {
                cur = cur.getNext();
            }

            cur.setNext(node);
        }

        LinkedNode loopHead = detectLoopHead(list);
        if(loopHead == null) {
            System.out.println("No loop found !!");
        }else {
            int index = list.getIndex(loopHead);
            System.out.println("Loop head "+loopHead.getData()+" found at pos "+index);
        }
    }

    private static  LinkedNode detectLoopHead(SinglyLinkedList list) {
        LinkedNode head = list.getHead().getNext(); //first node in the list , NOT the dummy head
        LinkedNode slow = head;
        LinkedNode fast = head;

        while(fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if(fast == slow) break;
        }

        if(fast == null || fast.getNext() == null) return  null;
        fast = head;

        while(fast != slow) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return fast;
    }
}