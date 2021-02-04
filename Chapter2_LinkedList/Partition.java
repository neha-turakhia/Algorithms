package Chapter2_LinkedList;

import Utils.LinkedNode;
import Utils.PrintUtil;
import Utils.SinglyLinkedList;

import java.util.Scanner;

public class Partition {

    /**
     * CTCI 2.4 Partition: Write code to partition linked list around a value x,
     *                     such that nodes less than x come before all the nodes greater than or equal to x.
     *                   If x is in the list, the values of x only need to be after the elements less than x.
     *                   The paritition element x can appear anywhere in the "right" partition,
     *                   it does not have to appear between the left and right partitions.
     *  Example
     * Input :  3-->5-->8-->5-->10-->2-->1 (x = 5)
     * Output : 3-->1-->2-->10-->5-->5-->8
     **/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i=0;i<length;++i){
            int val = scanner.nextInt();
            LinkedNode newNode = new LinkedNode(val);
            list.insertEnd(newNode);
        }
        int partitionValue = scanner.nextInt();
        PrintUtil.printLinkedList(list);
        SinglyLinkedList newList = partition(list,partitionValue);
        PrintUtil.printLinkedList(newList);
    }

    private static SinglyLinkedList partition(SinglyLinkedList linkedList, int partitionValue) {

        /*
        * Instead of creating 2 deep copies of all the nodes in the linked list , the code can be enhanced as follows :
            1. create 2 lists - left, right which will maintain shallow copy of the nodes.
            * Left will have all the nodes lesser than the partition value and right will have
            * all the nodes greater than or equal to the partition value.
            2. Point 1 is the ACTUAL SOLUTION OF THE PROBLEM. We create a deep copy of the list only to print
            * the result and is NOT NECESSARY TO FOLLOW as a part of the problem.


            Time Complexity : O(N) ~ loop through all the nodes of the actual list ,
            * we are not going to say it is O(2n) since deep copy of the final list is created only for printing the output and
            *  is NOT a part of the actual problem.

            Space Complexity : O(1) since we have 4 pointers that leftHead, left, rightHead and right.
            * We do not consider `newList` since it is created for printing the output and is NOT A PART OF THE ACTUAL SOLUTION.
        * */
        LinkedNode head = linkedList.getHead();
        if(head == null) return linkedList;
        if(head.getNext() == null) return linkedList;

        SinglyLinkedList newList = new SinglyLinkedList();
        LinkedNode left = null, right=null;
        LinkedNode leftHead = null, rightHead = null;
        // LinkedNode tail = head;
        LinkedNode current = head.getNext();
        while(current != null) {
            // if(current.next == originalTail) break;
            if(current.getData() >= partitionValue) {
                if(right == null) {
                    right = current;
                    rightHead = right;
                }else{
                    right.setNext(current);
                    right = right.getNext();
                }
            }else {
                if(left == null) {
                    left = current;
                    leftHead = left;
                }else {
                    left.setNext(current);
                    left = left.getNext();
                }
            }
            current = current.getNext();
        }

        right.setNext(null);

        if(leftHead != null) {
            left.setNext(rightHead);
            newList.insertAllAtEnd(leftHead);
        }else {
            newList.insertAllAtEnd(rightHead);
        }

        return newList;

    }
}