package Utils;


import java.util.Iterator;
import java.util.Stack;

public class PrintUtil {
    public static void printMatrix(int[][] mat) {
        System.out.println("----------------------------");
        for(int i=0;i<mat.length;++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                System.out.print(mat[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }

    public static void printLinkedList(SinglyLinkedList list){
        System.out.println("----------------------------");
        LinkedNode current = list.getHead().getNext();
        while(current != null) {
            System.out.print(current.getData()+"-->");
            current = current.getNext();
        }
        System.out.println("NULL\n----------------------------");
    }

    public static void printJavaStack(Stack stack) {
        Iterator i = stack.iterator();
        System.out.println("Stack from bottom to top");
        System.out.println("----------------------------");
        while(i.hasNext()){
            System.out.println(i.next()+"-->");
        }
        System.out.println("NULL\n----------------------------");
    }

    public static void printLinkedStack(LinkedStack stack) {
        System.out.println("Stack from top to bottom");
        System.out.println("----------------------------");
        LinkedNode node = stack.getTop();
        while(node.getNext() != null) {
            System.out.println(node.getNext().getData()+"-->");
            node = node.getNext();
        }
        System.out.println("NULL\n----------------------------");
    }


}