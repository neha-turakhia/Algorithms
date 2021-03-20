package Chapter4_TreesGraphs;

import Utils.PrintUtil;
import Utils.TreeNode;

import java.util.Scanner;

public class MinimalTree {
    /**
     * CTCI 4.2 Minimal Tree : Given a sorted (increasing order) array with unique integer elements,
     *                         write an algorithm to create a binary tree with minimal height.
     *
     * Approach : To ensure the tree is of minimal height the root should be in the middle.
     *            Since it is a sorted increasing order array it is safe to the take middle element
     *            for constructing a node when the boundary pointers are passed.
     *
     * Time Complexity : O(N) since we loop through the whole array to construct the tree
     * Space Complexity : O(N) for the new binary search tree
     * **/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the array and then the array..");
        int count = scanner.nextInt();
        int[] input = new int[count];
        for(int i=0;i<count;++i){
            input[i] = scanner.nextInt();
        }

        TreeNode root = constructBinarySearchTree(input);
        PrintUtil.printBinaryTree(root);
    }

    private static TreeNode constructBinarySearchTree(int[] arr) {
        return helper(arr,0, arr.length-1);
    }

    private static TreeNode helper(int[] arr, int beg, int end) {
        if(beg > end) return null;
        int mid = (beg+end)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.setLeft(helper(arr,beg,mid-1));
        root.setRight(helper(arr,mid+1,end));
        return root;
    }
}