package Utils;


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
}