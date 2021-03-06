package Chapter1_ArrayString;

import Utils.PrintUtil;

import java.util.Scanner;

public class RotateMatrix {

    /**
     * CTCI 1.7 Rotate Image : Given an image represented by an NxN matrix,
     *                         where each pixel in the image is 4 bytes,
     *                         write a method to rotate the image by 90 degrees. Can you do this in place?
     *  Added Followup : Do both clockwise & anti-clockwise rotation
     *
     *  Solution : to rotate a matrix - do matrix transpose and swap the rows/columns based on which direction to rotate.
     *              For clockwise - swap columns
     *              For anti-clockwise - swap rows
     *
     *  Time Complexity : O(N/2+N/2) = O(N)
     *  Space Complexity : O(1)
     *
     * **/


    static int[][] mat;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        mat = new int[n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                mat[i][j]=scanner.nextInt();
            }
        }

        System.out.println("Matrix Rotation Clockwise");
        rotateMatrixClockwise();
        PrintUtil.printMatrix(mat);
        System.out.println("Matrix Rotation Anti-Clockwise");
        rotateMatrixAntiClockwise();
        PrintUtil.printMatrix(mat);
    }

    private static void rotateMatrixClockwise() {
        /*
        * Input :
        *       1 2 3 4
        *       5 6 7 8
        *       9 10 11 12
        *       13 14 15 16
        *
        * Output :
        *
        *       13 9 5 1
        *       14 10  6 2
        *       15 11 7 3
        *       16 12 8 4
        * */
        transpose();
        PrintUtil.printMatrix(mat);
        //swap columns
        for(int i=0;i<mat.length;++i) {
            for (int j = 0; j <mat.length/2; ++j) {
                int swapCol = mat.length-j-1;
                int temp= mat[i][j];
                mat[i][j]= mat[i][swapCol];
                mat[i][swapCol]=temp;
            }
        }
        PrintUtil.printMatrix(mat);
        for(int i=0;i<mat.length;++i) {
            for (int j = 0; j <mat.length/2; ++j) {
                int swapCol = mat.length-j-1;
                int temp= mat[i][j];
                mat[i][j]= mat[i][swapCol];
                mat[i][swapCol]=temp;
            }
        }
        transpose();
    }
    private static void rotateMatrixAntiClockwise() {
        /*
        * Input :
        *       1 2 3 4
        *       5 6 7 8
        *       9 10 11 12
        *       13 14 15 16
        *
        * Output :
        *
        *       4 8 12 16
        *       3 7  11 15
        *       2 6 10 14
        *       1 5 9 13
        * */
        transpose();
        PrintUtil.printMatrix(mat);
        //swap rows
        for(int i=0;i<mat.length/2;++i) {
            for (int j = 0; j < mat.length; ++j) {
                int swapRow = mat.length-i-1;
                int temp= mat[i][j];
                mat[i][j]= mat[swapRow][j];
                mat[swapRow][j]=temp;
            }
        }
        PrintUtil.printMatrix(mat);
        for(int i=0;i<mat.length/2;++i) {
            for (int j = 0; j < mat.length; ++j) {
                int swapRow = mat.length-i-1;
                int temp= mat[i][j];
                mat[i][j]= mat[swapRow][j];
                mat[swapRow][j]=temp;
            }
        }
        transpose();
    }

    private static void transpose(){
        for(int i=0;i<mat.length;++i) {
            for (int j = 0; j < i; ++j) {
                int temp = mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]= temp;
            }
        }
    }
}