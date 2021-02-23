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

        LinkedNode node = list.getNodeAtIndex(pos);
        LinkedNode cur = list.getHead().getNext();
        while(cur != null && cur.getNext() != null) {
            cur = cur.getNext();
        }

        cur.setNext(node);

        LinkedNode loopHead = detectLoopHead(list);
        if(loopHead == null) {
            System.out.println("No loop found !!");
        }else {
            System.out.println("Loop head  :: "+loopHead.getData());
        }
    }

    private static  LinkedNode detectLoopHead(SinglyLinkedList list) {
        //TODO implement method
        return null;
    }
}