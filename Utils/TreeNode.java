package Utils;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode parent; //allowed or given in specific problems

    public TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getParent() {
        return parent;
    }
}