package Chapter2_LinkedList;

import Utils.LinkedNode;
import Utils.PrintUtil;
import Utils.SinglyLinkedList;

import java.util.Scanner;

public class Intersection {
    /**
     * CTCI 2.7 Intersection : Given two linked lists, determine if the two lists intersect. Return the intersecting node.
     *                         Note that intersection is based on reference, not value.
     *                         That is if the kth node of the first linked list is the exact same node (by reference) as the
     *                         jth node of the second linked list, then they are intersecting.
     **/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length1 = scanner.nextInt();
        SinglyLinkedList list1 = new SinglyLinkedList();
        for(int i=0;i<length1;++i){
            int value = scanner.nextInt();
            LinkedNode node = new LinkedNode(value);
            list1.insertEnd(node);
        }
        PrintUtil.printLinkedList(list1);

        int length2 = scanner.nextInt();
        SinglyLinkedList list2 = new SinglyLinkedList();
        for(int i=0;i<length2;++i){
            int value = scanner.nextInt();
            LinkedNode node = new LinkedNode(value);
            list2.insertEnd(node);
        }
        PrintUtil.printLinkedList(list2);

        LinkedNode intersectingNode = getIntersectionOf2Lists(list1,list2);
        if(intersectingNode == null) {
            System.out.println("No intersection found !!");
        }else{
            System.out.println("Intersecting Node value :: "+intersectingNode.getData());
        }

    }

    private static LinkedNode getIntersectionOf2Lists(SinglyLinkedList list1, SinglyLinkedList list2){
        LinkedNode intersectingNode = null;
        //TODO - implement method
        return intersectingNode;
    }

}