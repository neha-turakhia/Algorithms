package Chapter2_LinkedList;

import Utils.LinkedNode;
import Utils.PrintUtil;
import Utils.SinglyLinkedList;

import java.util.HashSet;
import java.util.Scanner;

/**
 * CTCI 2.1 Remove Dups : Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP How would you solve this problem if a temporary buffer is not allowed?
 *
 * Solution 1: Using a HashSet (temporary buffer)
 *  Time Complexity ; O(N)
 *  Space Complexity : O(N) for the hashset
 *
 *
 *  Solution 2: Without using temporary buffer by using 2 for loops
 *  Time Complexity - O(N^2) - since we have an inner loop that can have an upper bound of O(N-1) ~ O(N)
 *  Space Complexity ~ O(1) since we use 2 pointers
 * */
public class RemoveDups {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i=0;i<length;++i) {
            int val = scanner.nextInt();
            LinkedNode node = new LinkedNode(val);
            list.insertEnd(node);
        }

        PrintUtil.printLinkedList(list);
        removeDuplicates(list);
        PrintUtil.printLinkedList(list);
    }

    private static void removeDuplicates(SinglyLinkedList linkedList) {
        /** Solution 1: Using a temporary buffer - HashSet **/
        /**
         * Time Complexity - O(n)
         * Space Complexity ~ O(n) for the hash set
         * **/
       /* HashSet hm = new HashSet();
        LinkedNode current = linkedList.getHead();
        while(current != null && current.getNext() != null) {
            int value = current.getNext().getData();
            if(hm.contains(value)) {
                linkedList.deleteNextNode(current);
            }
            hm.add(value);
            current = current.getNext();
        } */


        /**Solution 2 : Without using a temporary buffer **/
        LinkedNode current = linkedList.getHead().getNext();

        while(current != null) {
            LinkedNode fastPtr = current;
            while (fastPtr != null && fastPtr.getNext() != null) {
                if(fastPtr.getNext().getData() == current.getData()) {
                    linkedList.deleteNextNode(fastPtr);
                }
                fastPtr = fastPtr.getNext();
            }
            current = current.getNext();
        }
    }
}
