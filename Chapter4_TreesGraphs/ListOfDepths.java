package Chapter4_TreesGraphs;

import java.util.*;

import Utils.*;

public class ListOfDepths {
    /**
     * CTCI 4.3 List of Depths : Given a binary tree , design an algorithm which creates a linked list
     *                           of all the nodes at each depth, (i.e) if you have a tree with depth D
     *                           you have D linked lists
     *
     * Approach 1 : Level Order traversal implemented using queues to fill up the resultant array
     * Time Complexity : O(N) where N is the number of nodes in a tree and each node is processed once
     * Space Complexity : O(N) for the output "result" list
     *
     * Approach 2 : Level Order Traversal using DFS by recursion
     * Time Complexity - O(N) where N is the number of nodes in a tree and each node is processed once
     * Space Complexity - O(N) for the output "result" list
     * **/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the input as a comma separated string giving null for a null node and enter the input in LEVEL ORDER");
        String input = scanner.nextLine();
        String[] treeInput = input.split(",");

        TreeNode root = BinaryTree.constructTreeForLevelOrderArray(treeInput);
        System.out.println("BFS Solution");
        List<SinglyLinkedList> listOfDepths = getListForDepthBFS(root);
        for(SinglyLinkedList list : listOfDepths){
            PrintUtil.printLinkedList(list);
        }

        System.out.println("DFS Solution");
         listOfDepths = getListForDepthDFS(root);
        for(SinglyLinkedList list : listOfDepths){
            PrintUtil.printLinkedList(list);
        }
    }

    private static List<SinglyLinkedList> getListForDepthBFS(TreeNode root){
        /*Solution 1 : Using BFS*/
        List<SinglyLinkedList> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);


        while(!q.isEmpty()){
            int size = q.size();
            SinglyLinkedList level = new SinglyLinkedList();
            for(int i=0;i<size;++i){
                TreeNode cur = q.poll();
                if(cur != null){
                    level.insertEnd(new LinkedNode(cur.getData()));
                    if(cur.getLeft() != null) {
                        q.offer(cur.getLeft());
                    }
                    if(cur.getRight() != null) {
                        q.offer(cur.getRight());
                    }
                }
            }
            if(level.getLength() > 0) {
                result.add(level);
            }
        }
        return result;
    }

    private static List<SinglyLinkedList> getListForDepthDFS(TreeNode root) {
        /*Solution 1 : Using DFS*/
        List<SinglyLinkedList> result = new ArrayList<>();
        helper(result,root,0);
        return result;
    }

    private static void helper(List<SinglyLinkedList> result, TreeNode current, int level){
        if(current != null) {
            int data = current.getData();
            SinglyLinkedList list = null;
            if(!result.isEmpty() && result.size()-1 >= level) {
                list = result.get(level);
                list.insertEnd(new LinkedNode(data));
                result.set(level,list);
            }else{
                list = new SinglyLinkedList();
                list.insertEnd(new LinkedNode(data));
                result.add(level,list);
            }




            if(current.getLeft() != null) {
                helper(result,current.getLeft(),level+1);
            }
            if(current.getRight() != null) {
                helper(result,current.getRight(),level+1);
            }

        }

    }

}