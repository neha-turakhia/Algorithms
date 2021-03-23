package Chapter4_TreesGraphs;

import Utils.BinaryTree;
import Utils.TreeNode;

import java.util.Scanner;

public class FirstCommonAncestor {
    /**
     * CTCI 4.8 First Common Ancestor : Design an algorithm and write code to find the first common ancestor
     *                                  of two nodes in a binary tree. Avoid storing additional nodes in a
     *                                  data structure.
     *                                  NOTE : this is not necessarily a binary search tree
     *
     * Approach 1 : We use recursion to find the first common ancestor with the assumption that if p and q
     *              occur in the same subtree , with one being the descendent of the other then upon finding
     *              either p/q we return that node (i.e) if a node is equal to p or q and its corresponding
     *              sibling subtree returns null for the value of p/q this node's subtree has the other value
     *              of p/q and we return that to be the first common ancestor.
     *
     * Time Complexity : O(N) where N is the no of nodes in the tree since we touch each node at least once.
     * Space Complexity : O(1)
     *
     *
     * Approach 2 : Here we maintain 3 enum values (0- not found, 1- any 1 found, 2 both found)
     *              to determine if we have found p or q in the node's subtree. Any node which has the value
     *              2 is the first common ancestor.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     **/

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the nodes of a binary tree in a comma separated level order fashion");
        String treeInput = scanner.nextLine();
        TreeNode root = BinaryTree.constructBinaryTree(treeInput);
        System.out.println("Enter the node P and Q in a comma separated");
        String pq = scanner.nextLine();
        String[] nodes = pq.split(",");
        TreeNode p = null, q = null;
        if(!nodes[0].equals("null")) {
            p = BinaryTree.find(root,Integer.parseInt(nodes[0]));
        }else {
            throw new Exception("Enter a valid value for Node P");
        }

        if(!nodes[1].equals("null")) {
            q = BinaryTree.find(root,Integer.parseInt(nodes[1]));
        }else {
            throw new Exception("Enter a valid value for Node Q");
        }

        System.out.println("Approach1 Solution : ");
        TreeNode lca = lowestCommonAncestor(root,p,q);
        if(lca != null) {
            System.out.println(lca.getData());
        }else {
            System.out.println("No common ancestor");
        }

        System.out.println("Approach2 Solution : ");
         lca = firstCommonAncestor(root,p,q);
        if(lca != null) {
            System.out.println(lca.getData());
        }else {
            System.out.println("No common ancestor");
        }
    }

    /*Solution 1*/
    private static TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return null;
        if(node == p || node == q) return node;
        TreeNode left = lowestCommonAncestor(node.getLeft(), p, q);
        TreeNode right = lowestCommonAncestor(node.getRight(), p, q);
        if(left != null && right != null) return node;
        else return (left != null) ? left : right;
    }

    /*Solution 2 : using integer enums*/
    private static TreeNode lca = null;
    private static TreeNode firstCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
       helper(root, p,q);
       return lca;
    }
    private static int helper(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return 0;
        int val =0;
        if(node == p || node == q){
            val = 1;
        }
        int left = helper(node.getLeft(), p, q);
        int right = helper(node.getRight(), p, q);

        if(left == 1 && right == 1) {
            val = 2;
        }
        else if(left == 1 || right == 1) {
            val = Math.max(left,right)+val;
        }
        if(val == 2) {
            lca = node;
        }
        return val;
    }
}