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

        System.out.println("Enter the position of the node of list1 which is the intersecting node");
        int pos = scanner.nextInt();
        if(pos < list1.getLength()) {
            LinkedNode connector = list1.getNodeAtIndex(pos);
            if(connector != null) {
                list2.insertAllAtEndWithSameRef(connector);
            }

            PrintUtil.printLinkedList(list2);
        }

        LinkedNode intersectingNode = getIntersectionOf2Lists(list1,list2);
        if(intersectingNode == null) {
            System.out.println("No intersection found !!");
        }else{
            System.out.println("Intersecting Node value :: "+intersectingNode.getData());
        }

    }

    private static LinkedNode getIntersectionOf2Lists(SinglyLinkedList list1, SinglyLinkedList list2){
        LinkedNode intersectingNode = null;

        /**Solution 1**/
        //Check if the tail of both the lists is the same
        LinkedNode tail1 = list1.getHead().getNext();
        while(tail1.getNext() != null){
            tail1 = tail1.getNext();
        }
        System.out.println("tail1 :"+tail1.getData());

        LinkedNode tail2 = list2.getHead().getNext();
        while(tail2.getNext() != null){
            tail2 = tail2.getNext();
        }
        System.out.println("tail2 :"+tail2.getData());

        if(tail1 != tail2){
            return intersectingNode; //return null since the lists do not intersect
        }

        System.out.println("Tail of both lists are the same, performing further checks....");

        int len1 = list1.getLength();
        int len2 = list2.getLength();

        LinkedNode cur1 = list1.getHead().getNext();
        LinkedNode cur2 = list2.getHead().getNext();

        if(len1 != len2){
            //if both the lists are not equal then skip those nodes in the longer list
            if(len1<len2){
                int diff = len2 - len1;
                while(diff-- > 0){
                    cur2 = cur2.getNext();
                }
            }else {
                int diff = len1 - len2;
                while(diff-- > 0){
                   cur1 = cur1.getNext();
                }
            }
        }

        while(cur1 != cur2){
            cur1 = cur1.getNext();
            cur2 = cur2.getNext();
        }

        intersectingNode = cur1;
        return intersectingNode;
    }

}