package Utils;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

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
}