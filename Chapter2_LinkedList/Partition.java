package Chapter2_LinkedList;

import Utils.LinkedNode;
import Utils.PrintUtil;
import Utils.SinglyLinkedList;

import java.util.Scanner;

public class Partition {
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
                    right = new LinkedNode(current.getData());
                    rightHead = right;
                }else{
                    right.setNext(new LinkedNode(current.getData()));
                    right = right.getNext();
                }
            }else {
                if(left == null) {
                    left = new LinkedNode(current.getData());
                    leftHead = left;
                }else {
                    left.setNext(new LinkedNode(current.getData()));
                    left = left.getNext();
                }
            }
            current = current.getNext();
        }

        if(leftHead != null) {
            newList.insertAllAtEnd(newList,leftHead);
            newList.insertAllAtEnd(newList,rightHead);
        }else {
            newList.insertAllAtEnd(newList,rightHead);
        }

        return newList;

    }
}