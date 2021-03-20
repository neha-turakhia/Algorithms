package Chapter4_TreesGraphs;

import Utils.BinaryTree;
import Utils.TreeNode;

import java.util.Scanner;

public class ValidateBST {
    /**
     * CTCI 4.5 Validate BST : Implement a function to check if the given binary tree is a binary search tree.
     *
     * Approach : In this problem it is not just enough to compare a node with its left and right children.
     *            Each subtree in the BST should also be a binary search tree and satisfy the condition that
     *            left descendents <= node <= right descendents. To validate this we pass a min and max value
     *            at every recursion to compare this.
     *
     * Time Complexity : O(N) where N is the number of nodes in a tree and we touch each node of the tree once.
     * Space Complexity : O(1)
     **/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the input as a comma separated string giving null for a null node and enter the input in LEVEL ORDER");
        String input = scanner.nextLine();
        String[] treeInput = input.split(",");

        TreeNode root = BinaryTree.constructTreeForLevelOrderArray(treeInput);
        boolean isBST = validateBST(root);
        System.out.println(isBST);
     }

    private static boolean validateBST(TreeNode root) {
        return helper(root,null,null);
    }

    private static boolean helper(TreeNode node, Integer min, Integer max) {
        if(node == null) return true;
        int val = node.getData();
        if(min != null && val < min) return false;
        if(max != null && val > max) return false;
        boolean left = helper(node.getLeft(), min, val);
        boolean right = helper(node.getRight(), val,max);
        return left && right;
    }

}