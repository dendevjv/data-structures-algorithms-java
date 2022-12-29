package dsalgjava.ch13.lst1301;

public class DfsApp {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1); // AB
        graph.addEdge(1, 2); // BC 
        graph.addEdge(0, 3); // AD
        graph.addEdge(3, 4); // DE
        
        System.out.println("Visits:");
        graph.dfs();
        System.out.println();
    }

}
