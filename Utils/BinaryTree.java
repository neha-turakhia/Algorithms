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

    /**
     * The string input expected here is a comma separated string with a level
     * ordering of the nodes of the binary tree.
     **/
    public static TreeNode constructBinaryTree(String input) {
        String[] treeInput = input.split(",");
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

    public static TreeNode constructBinaryTreeWithParentPointers(String input) {
        String[] treeInput = input.split(",");
        return treeHelperParentPtrs(treeInput,0,null);
    }

    private static TreeNode treeHelperParentPtrs(String[] arr,int index,TreeNode parent) {
        if(index >= arr.length) return null;
        if(arr[index].equals("null")) {
            return null;
        }
        int data = Integer.parseInt(arr[index]);
        TreeNode root = new TreeNode(data);
        root.setParent(parent);
        root.setLeft(treeHelperParentPtrs(arr,(2*index+1),root));
        root.setRight(treeHelperParentPtrs(arr,(2*index+2),root));
        return root;
    }

    public static TreeNode find(TreeNode root,int val) {
        if(root == null) return null;
        if(root.data == val) return root;
        TreeNode left = find(root.left,val);
        TreeNode right = find(root.right,val);
        return (left != null) ? left : (right != null) ? right : null;
    }



}