package Chapter4_TreesGraphs;

import java.util.*;

public class BuildOrder {
    /**
     * CTCI 4.7 Build Order : You are given a list of projects and a lit of dependencies (which is a list of paris of projects,
     *                        where the second project is dependent on the first project). All of the project dependencies
     *                        must be build before the project is. Find a build order that will allow the projects to be built.
     *                        If there is no build order , return error.
     *
     * EXAMPLE :
     * Input
     *  Projects a,b,c,d,e,f
     *  Dependencies (a,d) , (f,b) , (b,d), (f,a), (d,c)
     *
     * Output : f,e,a,b,d,c
     *
     * Approach : We first form an adjacency list of the dependencies. We also form an indegree map for all the vertices.
     *            The key is to do a topological sort of all the nodes (projects) that we represent in the form of a graph.
     *            To do a topological sort, add all the nodes with indegree 0 (these projects should come first since they can
     *            be built without any dependencies) to a queue, poll each one out and decrement the indegree of its dependents.
     *            Add the dependents to the queue only if their indegree also reaches 0. Process all the nodes in the same fashion.
     *
     * Time Complexity : O(N+D) where N is the number of projects and D is the number of dependencies ~
     *                   O(V+E) for a graph where projects are represented as vertices and dependencies as edges
     * Space Complexity : O(N*D) where N is the number of projects and D is the number of dependencies ~
     *                   O(VE) for a graph where projects are represented as vertices and dependencies as edges
     *
     * **/

    private static HashMap<String, List<String>> depMap;
    private static HashMap<String,Integer> indegree ;
    private static String[] projects;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the projects as a comma separated string");
        String proj = scanner.nextLine();
        projects = proj.split(",");
        initialize(projects);
        String[][] dependencies;
        System.out.println("Enter each dependency as a comma separated string , each dependency pair should be separated by a ;");
        String dependents = scanner.nextLine();
        String[] dependentsArray = dependents.split(";");
        dependencies = new String[dependentsArray.length][2];
        for(int i=0;i<dependentsArray.length;++i) {
            String[] arr = dependentsArray[i].split(",");
            dependencies[i][0] = arr[0];
            dependencies[i][1] = arr[1];
        }

        formAdjcencyMap(dependencies);
        String finalOrder = topologicalSort();

        if(finalOrder != null && finalOrder.length() > 0) {
            System.out.println(finalOrder);
        }else {
            System.out.println("No valid build order!!!!!");
        }
    }

    private static void initialize(String[] projects) {
        depMap = new HashMap<>();
        indegree = new HashMap();
        for(String p:projects){
            depMap.put(p,new ArrayList<>());
            indegree.put(p,0);
        }
    }

    private static void formAdjcencyMap(String[][] dependencies){
        for(String[] dependency: dependencies){
            String pname = dependency[0];
            String dname = dependency[1];
            List<String> depList = (depMap.get(pname));
            depList.add(dname);
            indegree.put(dname,indegree.get(dname)+1);
        }
    }

    private static String topologicalSort(){
        List<String> buildOrder = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        for(int i=0;i<projects.length;++i){
            if(indegree.get(projects[i]) == 0){
                q.offer(projects[i]);
            }
        }

        while(!q.isEmpty()){
            String project_name = q.poll();
            buildOrder.add(project_name);

            List<String> dependency = depMap.get(project_name);
            for(String d:dependency) {
                indegree.put(d,indegree.get(d)-1);
                if(indegree.get(d) == 0) {
                    q.offer(d);
                }
            }

        }

        String finalOrder = String.join(",",buildOrder);
        return finalOrder;
    }
}