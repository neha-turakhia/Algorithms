package Chapter2_LinkedList;

import Utils.LinkedNode;
import Utils.PrintUtil;
import Utils.SinglyLinkedList;

import java.util.HashSet;
import java.util.Scanner;

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
        /*HashSet hm = new HashSet();
        LinkedNode current = linkedList.getHead().getNext();
        while(current != null) {
            int value = current.getData();
            if(hm.contains(value)) {
                linkedList.deleteAtIndex(linkedList.getIndex(current));
            }
            hm.add(value);
            current = current.getNext();
        }*/


        /**Solution 2 : Without using a temporary buffer **/
        /**
         * Time Complexity - O(n^2) - since we have an inner loop that can have an upper bound of O(n-1) ~ O(n)
         * Space Complexity ~ O(1) since we use 2 pointers
         * **/
        LinkedNode current = linkedList.getHead().getNext();

        while(current != null) {
            LinkedNode fastPtr = current.getNext();
            while (fastPtr != null) {
                if(fastPtr.getData() == current.getData()) {
                    linkedList.deleteAtIndex(linkedList.getIndex(fastPtr));
                }
                fastPtr = fastPtr.getNext();
            }
            current = current.getNext();
        }
    }
}
