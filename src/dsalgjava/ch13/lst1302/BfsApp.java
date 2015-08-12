package dsalgjava.ch13.lst1302;

public class BfsApp {

    public static void main(String[] args) {
        GraphBfs graph = new GraphBfs();
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
        graph.bfs();
        System.out.println();
    }

}
