package Chapter2_LinkedList;

import Utils.LinkedNode;
import Utils.PrintUtil;
import Utils.SinglyLinkedList;

import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    /**
     * CTCI 2.6 Palindrome : Implement a function to check if a linked list is a palindrome.
     **/

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
        int length = list.getLength(); //this operation usually takes O(n) since we would need to manually calculate the length
        boolean isPalindrome = true;

        /*LinkedNode cur = list.getHead().getNext();
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
        } */


        /*Solution 2 : using stacks without length known */
        LinkedNode cur = list.getHead(); //first node of the list
        LinkedNode fast = cur;
        while(fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            cur = cur.getNext();
        }

        boolean isOddLength = (fast == null) ? true : false;


        //Add elements into the stack from cur.next & preserve cur value
        LinkedNode stackStart = cur.getNext();
        Stack<Integer> stack = new Stack<>();
        while(stackStart != null) {
            stack.push(stackStart.getData());
            stackStart = stackStart.getNext();
        }

        if(isOddLength) {
            LinkedNode ptr = list.getHead().getNext();
            while(ptr != cur && !stack.empty()) {
                int data = ptr.getData();
                int stackTop = stack.pop();
                if(data != stackTop) {
                    isPalindrome = false;
                    break;
                }
               ptr = ptr.getNext();
            }
        }else {
            LinkedNode ptr = list.getHead().getNext();
            while(ptr != cur.getNext() && !stack.empty()) {
                int data = ptr.getData();
                int stackTop = stack.pop();
                if(data != stackTop) {
                    isPalindrome = false;
                    break;
                }
                ptr = ptr.getNext();
            }
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