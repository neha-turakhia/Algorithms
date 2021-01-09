package ArrayString;

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
}