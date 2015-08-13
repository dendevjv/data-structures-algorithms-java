package dsalgjava.ch13.lst1304;

public class TopoApp {

    public static void main(String[] args) {
        GraphTopo graph = new GraphTopo();
        graph.addVertex('A');   // 0
        graph.addVertex('B');   // 1
        graph.addVertex('C');   // 2
        graph.addVertex('D');   // 3
        graph.addVertex('E');   // 4
        graph.addVertex('F');   // 5
        graph.addVertex('G');   // 6
        graph.addVertex('H');   // 7
        
        graph.addEdgeDirected(0, 3);    // AD
        graph.addEdgeDirected(0, 4);    // AE
        graph.addEdgeDirected(1, 4);    // BE
        graph.addEdgeDirected(2, 5);    // CF
        graph.addEdgeDirected(3, 6);    // DG
        graph.addEdgeDirected(4, 6);    // EG
        graph.addEdgeDirected(5, 7);    // FH
        graph.addEdgeDirected(6, 7);    // GH
        
        graph.topo();
    }

}
