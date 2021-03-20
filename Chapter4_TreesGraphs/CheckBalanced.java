package Chapter4_TreesGraphs;

import Utils.BinaryTree;
import Utils.TreeNode;

import java.util.Scanner;

public class CheckBalanced {
    /**
     * CTCI 4.4 Check Balanced : Implement a function to check if a binary tree is balanced.
     *                          For the purposes of this question , a balanced tree is defined
     *                          to be a tree such that the heights of the 2 subtrees of any node
     *                          never differ by more than one.
     *
     * Approach : Calculate the height of each subtree at every node recursively , if the subtree height differs
     *            by 1 then return an error code.
     *
     * Time Complexity : O(N) where N is the number of nodes in the tree and we touch each node once.
     * Space Complexity : O(1)
     **/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the input as a comma separated string giving null for a null node and enter the input in LEVEL ORDER");
        String input = scanner.nextLine();
        String[] treeInput = input.split(",");

        TreeNode root = BinaryTree.constructTreeForLevelOrderArray(treeInput);
        boolean isBalanced = checkBalanced(root);
        System.out.println(isBalanced);
    }

    private static boolean checkBalanced(TreeNode root) {
        int height = helper(root);
        return (height != Integer.MAX_VALUE);
    }

    private static int helper(TreeNode node) {
        if(node == null) return 0;
        if(node.getLeft() == null && node.getRight() == null) return 1;
        int left = helper(node.getLeft());
        int right = helper(node.getRight());
        if(Math.abs(left-right) > 1) return Integer.MAX_VALUE;
        int height = Math.max(left,right)+1;
        return height;
    }

}