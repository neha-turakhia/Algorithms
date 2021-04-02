package Chapter4_TreesGraphs;

import Utils.BinaryTree;
import Utils.TreeNode;

import java.util.Scanner;

public class CheckSubtree {

    /**
     * CTCI 4.10 Check Subtree: T1 and T2 are two very large binary trees , T1 is much bigger than T2.
     *                          Create an algorithm to determine if T2 is a subtree of T1.
     *                          If T2 is a subtree of T1 there exiists a node n inT1 such that the subtree of n is identical
     *                          to T2. That is, if you cut off that tree at node n, the two trees would be identical.
     *
     * Approach :  We used recursion to go downwards to check for the subtree. Here it is key to have a method that checks for
     *             the same tree, to avoid errors in the edge case where all the nodes of t2 would be present in t1 but would not be a part of
     *             the same subtree.
     *
     * Time Complexity : O(N*M) where N is the number of nodes in the tree t1 and M is the number of nodes in tree t2
     * Space Complexity : O(1) if we don't count the recursion stack, if we count the recursion stack it is O(N)
     *                    where N is the number of nodes in tree t1 (for a skewed tree)
     * **/
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the binary tree T1 in level order , comma separating the nodes");
        String treeInput = scanner.nextLine();
        TreeNode t1 = BinaryTree.constructBinaryTree(treeInput);

        System.out.println("Enter the binary tree T2 in level order , comma separating the nodes");
        treeInput = scanner.nextLine();
        TreeNode t2 = BinaryTree.constructBinaryTree(treeInput);

        boolean isSubtree = isSubtree(t1,t2);
        System.out.println(isSubtree);
    }

    private static boolean isSubtree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(isSameTree(t1,t2)) return true;
        return isSubtree(t1.getLeft(),t2) || isSubtree(t1.getRight(),t2);
    }

    private static boolean isSameTree(TreeNode t1,TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.getData() != t2.getData()) return false;
        else return isSameTree(t1.getLeft(),t2.getLeft()) && isSameTree(t1.getRight(),t2.getRight());
    }
}