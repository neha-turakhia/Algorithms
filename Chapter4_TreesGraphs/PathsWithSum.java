package Chapter4_TreesGraphs;

import Utils.BinaryTree;
import Utils.TreeNode;

import java.util.HashMap;
import java.util.Scanner;

public class PathsWithSum {
    /**
     * CTCI 4.12 Paths with Sum : You are given a binary tree in which each node contains an integer value
     *                            (which may be positive or negative). Design an algorithm to count the number of paths
     *                            that sum to a given value. The path does not need to start or end at the root or a leaf,
     *                            but it must go downwards (travelling only from parent nodes to child nodes)
     *
     * Approach : We use recursion with memoization with the help of a hashmap. A number of solutions for this problem
     *            involve forming a list of root to leaf paths containing all the nodes and then loop through the list
     *            to find a subarray matching the target sum.
     *
     *            We have used a BETTER approach by using a hashmap , we increment the path count if the current sum is
     *            equal to the target sum. Then we compute the diff (currentSum-targetSum) and check if the diff is present
     *            in the hashmap, if it is present this means there exists a subarray which adds up to the targetSum hence we
     *            increment the pathCount with the number of times the diff is present
     *
     * Time Complexity : O(N) where N is the number of nodes in the tree
     * Space Complexity : O(N) for the hashmap
     * **/

    private static int pathCount;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the binary tree in level order with nodes comma separated");
        String treeInput = scanner.nextLine();
        System.out.println("Enter the target sum");
        int targetSum = scanner.nextInt();
        TreeNode root = BinaryTree.constructBinaryTree(treeInput);
        pathCount = 0;
        pathSum(root,0,targetSum,new HashMap<Integer,Integer>());
        System.out.println(pathCount);
    }

    private static void pathSum(TreeNode node,int currentSum,int targetSum, HashMap<Integer,Integer> hm){
        if(node == null) return;
        currentSum += node.getData();

        if(currentSum == targetSum) pathCount++;

        int diff = currentSum-targetSum;

        if(hm.containsKey(diff)) {
            pathCount += hm.get(diff);
        }

        hm.put(currentSum,hm.getOrDefault(currentSum,0)+1);
        pathSum(node.getLeft(),currentSum,targetSum,hm);
        pathSum(node.getRight(),currentSum,targetSum,hm);
        hm.put(currentSum,hm.getOrDefault(currentSum,0)-1);
    }
}