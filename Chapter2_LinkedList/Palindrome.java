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
        return isPalindrome;
    }
}