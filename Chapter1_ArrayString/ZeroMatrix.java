package Chapter1_ArrayString;

import Utils.PrintUtil;

import java.util.Scanner;

public class ZeroMatrix {

    /**
     * CTCI 1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
     *
     * Solution : Let M be the no of rows , N be the no of columns.
     *            Traverse the first row and column to check for zeros, then traverse the remaining matrix and upon encountering a 0
     *            set the corresponding column and row in the first row and column to 0. Here the first row/column acts like flag which
     *            determines if that corresponding row/column should be set to 0. Once done, set the corresponding row/column to 0 based
     *            on the values set in the first row/column. And then set the first row/column to 0 based on the boolean value.
     *
     *  Time Complexity : 0(M+N+(M-1)(N-1)+M+N) ~ O(MN)
     *  Space Complexity : O(1)
     *
     * **/
    static int[][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        matrix = new int[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                matrix[i][j]= scanner.nextInt();
            }
        }

        zeroMatrix();
        PrintUtil.printMatrix(matrix);
    }

    private static void zeroMatrix(){
        boolean rowHasZero = false;
        boolean colHasZero = false;

        for(int j=0;j<matrix[0].length;++j){
            if(matrix[0][j] == 0) {
                rowHasZero=true;
                break;
            }
        }

        for(int i=0;i<matrix.length;++i){
            if(matrix[i][0] == 0) {
                colHasZero=true;
                break;
            }
        }

        for(int i=1;i<matrix.length;++i){
            for(int j=1;j<matrix[i].length;++j) {
                if(matrix[i][j]==0) {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<matrix.length;++i) {
            if(matrix[i][0] == 0) {
                nullifyRow(i);
            }
        }

        for(int j=1;j<matrix[0].length;++j) {
            if(matrix[0][j] == 0) {
                nullifyColumn(j);
            }
        }

        if(rowHasZero) {
            nullifyRow(0);
        }
        if(colHasZero){
            nullifyColumn(0);
        }
    }

    private static void nullifyRow(int row){
        for(int col=0;col<matrix[row].length;++col){
            matrix[row][col]=0;
        }
    }

    private static void nullifyColumn(int col){
        for(int row=0;row<matrix.length;++row){
            matrix[row][col]=0;
        }
    }
}