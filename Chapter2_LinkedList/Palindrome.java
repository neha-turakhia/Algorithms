package Chapter2_LinkedList;

import Utils.LinkedNode;
import Utils.PrintUtil;
import Utils.SinglyLinkedList;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for(int i=0;i<length;++i){
            int value = scanner.nextInt();
            LinkedNode node = new LinkedNode(value);
            linkedList.insertEnd(node);
        }
        PrintUtil.printLinkedList(linkedList);
        boolean isPalindrome = isLinkedListPalindrome(linkedList);
        System.out.println(isPalindrome);
    }

    private static boolean isLinkedListPalindrome(SinglyLinkedList list){
        int length = list.getLength();
        boolean isPalindrome = true;
        //TODO : Implement Solution
        LinkedNode cur = list.getHead().getNext();
        for(int k=0;k<length/2;++k){
            cur = cur.getNext();
        }

        boolean evenLength = (length%2 == 0) ? true:false;
        LinkedNode revList = null;
        if(evenLength) {
            revList = reverse(cur);
        }else {
            revList = reverse(cur.getNext());
        }

        LinkedNode listHead = list.getHead().getNext();
        while(listHead != null && revList != null) {
            int listData = listHead.getData();
            int revListData = revList.getData();
            if(listData != revListData) {
                isPalindrome = false;
                break;
            }
            listHead = listHead.getNext();
            revList = revList.getNext();
        }
        return isPalindrome;
    }

    private static LinkedNode reverse(LinkedNode head){
        LinkedNode current = head;
        LinkedNode revList = null;

        while(current != null) {
            LinkedNode temp = current.getNext();
            current.setNext(revList);
            revList = current;
            current = temp;
        }
        return revList;
    }
}