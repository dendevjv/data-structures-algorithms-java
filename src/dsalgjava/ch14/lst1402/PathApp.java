package dsalgjava.ch14.lst1402;

public class PathApp {

    public static void main(String[] args) {
        GraphWD graph = new GraphWD();
        graph.addVertex('A');   // 0
        graph.addVertex('B');   // 1
        graph.addVertex('C');   // 2
        graph.addVertex('D');   // 3
        graph.addVertex('E');   // 4
        
        graph.addEdgeDirected(0, 1, 50);    // AB 50
        graph.addEdgeDirected(0, 3, 80);    // AD 80
        graph.addEdgeDirected(1, 2, 60);    // BC 60
        graph.addEdgeDirected(1, 3, 90);    // BD 90
        graph.addEdgeDirected(2, 4, 40);    // CE 40
        graph.addEdgeDirected(3, 2, 20);    // DC 20
        graph.addEdgeDirected(3, 4, 70);    // DE 70
        graph.addEdgeDirected(4, 1, 50);    // EB 50
        
        System.out.println("Shortest paths");
        graph.path();
        System.out.println();
    }

}
