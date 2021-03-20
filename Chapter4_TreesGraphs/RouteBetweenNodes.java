package Chapter4_TreesGraphs;

import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class RouteBetweenNodes {
    /**
     * CTCI 4.1 Route Between Nodes: Given a directed graph , design an algorithm to find out whether
     *                               there is a route between 2 nodes.
     *
     *
     * Solution 1: Implemented by using queues to implement a BFS
     * Time Complexity : O(V) since we use the visited flag to add nodes into the queue
     * Space Complexity : O(VE +V) ~ O(VE) for the adjacency matrix
    *
     * Solution 2:  Implemented by using DFS with recursion
     * Time Complexity : O(V) since we use the visited flag to recurse over the helper method
     * Space Complexity :  O(VE +V) ~ O(VE) for the adjacency matrix
     * **/

    private static HashMap<Integer,HashSet<Integer>> adjMat = new HashMap<>();
    private static boolean [] visited;
    private static int vertices;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the no of vertices, it is assumed the vertices are from 0 to n-1");
        vertices = scanner.nextInt();
        visited = new boolean[vertices];
        initialize(vertices);
        System.out.println("Enter the no of edges");
        int edge_count = scanner.nextInt();
        int[][] edges = new int[edge_count][2];
        for(int i=0;i<edge_count;++i) {
            for(int j=0;j<2;++j){
                edges[i][j] = scanner.nextInt();
            }
        }
        int vertexA = scanner.nextInt();
        int vertexB = scanner.nextInt();

        formAdjMatrix(edges);
        boolean hasPath = findRouteUsingBFS(vertexA,vertexB);
        System.out.println("BFS Verdict : "+hasPath);
        hasPath = findRouteUsingDFS(vertexA,vertexB);
        System.out.println("DFS Verdict : "+hasPath);
    }

    private static void initialize(int vertices) {
        for(int i=0;i<vertices;++i) {
            adjMat.put(i,new HashSet<>());
        }
    }
    private static void formAdjMatrix(int[][] edges) {
        for(int[] edge: edges) {
            //since this is a directed graph we will be adding only 1 entry in the adj matrix
            HashSet<Integer> neighbours = adjMat.get(edge[0]);
            neighbours.add(edge[1]);
            adjMat.put(edge[0],neighbours);
        }

    }

    private static boolean findRouteUsingBFS(int vertexA, int vertexB) {
        /*Solution 1: BFS using Queues*/
        visited = new boolean[vertices];
        Queue<Integer> q = new LinkedList<>();
        q.offer(vertexA);

        while(!q.isEmpty()) {
            int vertex = q.poll();
            visited[vertex]=true;
            HashSet<Integer> neighbours = adjMat.get(vertex);
            if(neighbours.contains(vertexB)) {
                return true;
            }
            for(Integer neighbour:neighbours) {
                if(!visited[neighbour]) {
                    q.offer(neighbour);
                }
            }
        }
        return false;
    }

    private static boolean findRouteUsingDFS(int vertexA, int vertexB) {
        /*Solution 2: DFS*/
        visited = new boolean[vertices];
        return helper(vertexA,vertexB);
    }

    private static boolean helper(int verA,int verB) {
        HashSet<Integer> neighbours = adjMat.get(verA);
        visited[verA]=true;
        if(neighbours.contains(verB)) return true;
        for(int neighbour:neighbours) {
            if(!visited[neighbour]) {
                boolean contains = helper(neighbour, verB);
                if (contains) {
                    return true;
                }
            }
        }
        return false;
    }
}
