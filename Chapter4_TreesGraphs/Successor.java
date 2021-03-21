package Chapter4_TreesGraphs;

import Utils.BinaryTree;
import Utils.TreeNode;

import java.util.Scanner;

public class Successor {

    /**
     *  CTCI 4.6 Successor : Write an algorithm to find the "next" node (i.e., in-order successor)
     *                       of a given node in a binary search tree. You may assume each node has a link
     *                       to its parent.
     *
     *
     *  Approach : there are 2 cases for a successor in a BST, it can either be in the right sub tree, or it could be the parent node.
     *             For RST, keep going left till the value is null and return that as the successor.
     *             For parent, keep going up till the value is greater.
     *
     * Time Complexity: O(log N) where N is the no of nodes in the tree , the complexity is log N for a decently balanced tree
     *                  and O(N) for the worst case.
     *
     * Space Complexity : O(1) since no additional space is used
     **/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the input as a comma separated string giving null for a null node and enter the input in LEVEL ORDER");
        String input = scanner.nextLine();

        TreeNode root = BinaryTree.constructBinaryTreeWithParentPointers(input);
        System.out.println("Enter node value whose successor you want to find");
        int nodeVal = scanner.nextInt();
        TreeNode node = BinaryTree.find(root,nodeVal);

        TreeNode successor = inorderSuccessorWithParentPtrs(node);
        if(successor != null){
            System.out.println(successor.getData());
        }else {
            System.out.println("No successor in the tree !!");
        }
    }

    private static TreeNode inorderSuccessorWithParentPtrs(TreeNode node){
        TreeNode successor = null;
        if(node.getRight() != null) {
            successor = node.getRight();
            TreeNode cur = successor;
            while(cur.getLeft() != null) {
                cur = cur.getLeft();
            }
            if(cur != null && cur != successor) {
                successor = cur;
            }
        }else {
            TreeNode parent = node.getParent();
            while(parent != null && parent.getData() < node.getData()){
                parent = parent.getParent();
            }
            successor = parent;
        }
        return successor;
    }

    public TreeNode inorderSuccessorWithoutParentPtrs(TreeNode root, TreeNode p) {
        /*
        * Solution - Finding the inorder successor without parent pointers
        * */
        TreeNode successor = null;
        if(p.getRight() != null){
            successor = p.getRight();
            TreeNode cur = p.getRight();
            while(cur.getLeft() != null) {
                cur = cur.getLeft();
            }
            if(cur != null && cur != successor) {
                successor = cur;
            }
        }else{
            TreeNode prev = null;
            TreeNode next = root;
            while(next != p) {
                if(next.getData() < p.getData()) {
                    next = next.getRight();
                }else {
                    prev = next;
                    next = next.getLeft();
                }
            }
            successor = prev;
        }
        return successor;

    }
}