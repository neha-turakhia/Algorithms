package Utils;

public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(TreeNode node) {
        this.root = node;
    }

    public static void printPreOrder(TreeNode root) {
        if(root == null) {
            System.out.print("null  ");
        }
        else
        {
            System.out.print(root.getData()+"  ");
            printPreOrder(root.getLeft());
            printPreOrder(root.getRight());
        }
    }

}