package dsalgjava.ch13.progproj.pp1302;

public class GraphAdjListsApp {

    public static void main(String[] args) {
        GraphAdjLists graph = new GraphAdjLists();
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
