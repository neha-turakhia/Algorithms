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

    public static TreeNode constructTreeForLevelOrderArray(String[] treeInput) {
        return helperLevelOrder(treeInput,0);
    }

    private static TreeNode helperLevelOrder(String[] arr,int index) {
        if(index >= arr.length) return null;
        if(arr[index].equals("null")) {
            return null;
        }
        int data = Integer.parseInt(arr[index]);
        TreeNode root = new TreeNode(data);
        root.setLeft(helperLevelOrder(arr,2*index+1));
        root.setRight(helperLevelOrder(arr,2*index+2));
        return root;
    }

}