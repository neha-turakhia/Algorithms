package Chapter2_LinkedList;

import Utils.LinkedNode;
import Utils.PrintUtil;
import Utils.SinglyLinkedList;

import java.util.Scanner;

public class SumLists {
    private static final int REVERSE_ORDER = 1;
    private static final int FORWARD_ORDER = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int problemConst = scanner.nextInt();
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();

        int len1 = scanner.nextInt();
        for(int i=0;i<len1;++i){
            int data = scanner.nextInt();
            LinkedNode newNode = new LinkedNode(data);
            list1.insertEnd(newNode);
        }

        int len2 = scanner.nextInt();
        for(int i=0;i<len2;++i){
            int data = scanner.nextInt();
            LinkedNode newNode = new LinkedNode(data);
            list2.insertEnd(newNode);
        }



       switch (problemConst){
           case REVERSE_ORDER:
               System.out.println("REVERSE ORDER CHOSEN");
               System.out.println("LIST 1");
               PrintUtil.printLinkedList(list1);
               System.out.println("LIST 2");
               PrintUtil.printLinkedList(list2);
               System.out.println("SUM");
               SinglyLinkedList reverseOrderSum = reverseOrderSum(list1,list2);
               PrintUtil.printLinkedList(reverseOrderSum);
               break;
           case FORWARD_ORDER:
               System.out.println("FORWARD ORDER CHOSEN");
               System.out.println("LIST 1");
               PrintUtil.printLinkedList(list1);
               System.out.println("LIST 2");
               PrintUtil.printLinkedList(list2);
               System.out.println("SUM");
               SinglyLinkedList forwardOrderSum = forwardOrderSum(list1,list2);
               PrintUtil.printLinkedList(forwardOrderSum);
               break;
       }
    }

    private static SinglyLinkedList reverseOrderSum(SinglyLinkedList list1, SinglyLinkedList list2){
        return linkedListSum(list1,list2,REVERSE_ORDER);
    }

    private static SinglyLinkedList linkedListSum(SinglyLinkedList list1, SinglyLinkedList list2,int linkedListOrder){
        SinglyLinkedList sumList = new SinglyLinkedList();
        int sum = 0,  carry = 0;
        LinkedNode cur1 = list1.getHead().getNext();
        LinkedNode cur2 = list2.getHead().getNext();

        while(cur1 != null || cur2 != null) {
            int val1 = (cur1 == null) ? 0 : cur1.getData();
            int val2 = (cur2 == null) ? 0 : cur2.getData();

            sum = val1+val2+carry;
            carry = sum/10;
            int value = sum%10;
            switch (linkedListOrder) {
                case REVERSE_ORDER: sumList.insertEnd(new LinkedNode(value));
                    break;
                case FORWARD_ORDER: sumList.insertBeginning(new LinkedNode(value));
                    break;
            }

            cur1 = (cur1 != null) ? cur1.getNext() : null;
            cur2 =(cur2 != null) ? cur2.getNext() : null;
        }
        if(carry != 0) {
            switch (linkedListOrder) {
                case REVERSE_ORDER: sumList.insertEnd(new LinkedNode(carry));
                    break;
                case FORWARD_ORDER: sumList.insertBeginning(new LinkedNode(carry));
                    break;
            }
        }
        return sumList;
    }

    private static SinglyLinkedList forwardOrderSum(SinglyLinkedList list1, SinglyLinkedList list2){
        /**
         * Solution 1: reverse the lists and then add each digit and insert in the beginning of the final list
         * **/
       /* list1.reverseList();
        list2.reverseList();

        SinglyLinkedList sumList = linkedListSum(list1,list2,FORWARD_ORDER);
        return sumList;*/

        /**
         * Solution 2 : add the elements in the order and then correct the input from reverse
         * **/
        //TODO : Implement Solution2
        int list1_len = list1.getLength();
        int list2_len = list2.getLength();
        if(list1_len != list2_len) {
            if(list1_len > list2_len) {
                addPaddingZeros(list2,list1_len-list2_len);
            }else{
                addPaddingZeros(list1,list2_len-list1_len);
            }
        }

        SinglyLinkedList intermediateList = new SinglyLinkedList();
        LinkedNode cur1 = list1.getHead().getNext();
        LinkedNode cur2 = list2.getHead().getNext();

        while(cur1 != null && cur2 != null){
            int sum = cur1.getData() + cur2.getData();
            intermediateList.insertEnd(new LinkedNode(sum));
            cur1 = cur1.getNext();
            cur2 = cur2.getNext();
        }

        intermediateList.reverseList();
        int carry = 0;
        LinkedNode current = intermediateList.getHead().getNext();
        while(current != null) {
            int data = current.getData()+carry;
            int newVal = (data%10);
            current.setData(newVal);
            carry = data/10;
            current = current.getNext();
        }
        if(carry != 0) {
            intermediateList.insertEnd(new LinkedNode(carry));
        }
        intermediateList.reverseList();
        return intermediateList;

    }

    private static void addPaddingZeros(SinglyLinkedList list, int count){
        for(int i=0;i<count;++i){
            list.insertBeginning(new LinkedNode(0));
        }
    }
}