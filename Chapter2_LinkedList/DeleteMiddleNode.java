package Chapter2_LinkedList;

import Utils.LinkedNode;
import Utils.PrintUtil;
import Utils.SinglyLinkedList;

import java.util.Scanner;

/**
 * CTCI 2.3 Delete middle node: Implement an algorithm to delete a node in the middle of a singly linked list.
 * (i.e any node but the first and last node), given only access to that node.
 *
 * Solution : Set the middle node value to the value of the next node and delete the next node.
 *
 * Time Complexity : O(1)
 * Space Complexity : O(1)
 **/

public class DeleteMiddleNode {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Form your linked list");
        int length = scanner.nextInt();
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i=0;i<length;++i) {
            int val = scanner.nextInt();
            LinkedNode node = new LinkedNode(val);
            list.insertEnd(node);
        }

        PrintUtil.printLinkedList(list);

        System.out.println("Enter the index of the middle node which should be deleted. Middle node is any node apart from the first or the last node of the linked list.");
        int middleIndex = scanner.nextInt();
        if(middleIndex == 0 || middleIndex >= list.getLength()-1){
            throw new Exception("Invalid Value entered for Middle Index!!!");
        }
        LinkedNode middleNode = list.getNodeAtIndex(middleIndex);
        deleteMiddleNode(middleNode);
        PrintUtil.printLinkedList(list);
    }

    private static void deleteMiddleNode(LinkedNode middleNode){
        if(middleNode != null && middleNode.getNext()!= null){
            LinkedNode nextPtr = middleNode.getNext();
            middleNode.setData(nextPtr.getData());
            middleNode.setNext(nextPtr.getNext());
            nextPtr.setNext(null);
        }
    }
}