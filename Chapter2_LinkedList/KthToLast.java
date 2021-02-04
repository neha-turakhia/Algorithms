package Chapter2_LinkedList;

import Utils.LinkedNode;
import Utils.PrintUtil;
import Utils.SinglyLinkedList;

import java.util.Scanner;

/**
 * CTCI 2.2 Return kth to last : Implement an algorithm to find the kth to last element of a singly linked list.
 **/

public class KthToLast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for(int i=0;i<length;++i){
            int value = scanner.nextInt();
            LinkedNode node = new LinkedNode(value);
            linkedList.insertEnd(node);
        }
        int k = scanner.nextInt();

        PrintUtil.printLinkedList(linkedList);
        int kthValue = findKthToLast(linkedList,k);
        System.out.println("The "+k+"th element from the last is : "+kthValue);
    }

    private static int findKthToLast(SinglyLinkedList list,int k) {
        if(k > list.getLength()) return -1;
        if(k <= 0) k =1;
        LinkedNode current = list.getHead().getNext();
        LinkedNode runner = current;

        int index=0;
        while (index++ < k) {
            runner = runner.getNext();
        }

        while (runner != null) {
            current = current.getNext();
            runner = runner.getNext();
        }
        return current.getData();
    }
}