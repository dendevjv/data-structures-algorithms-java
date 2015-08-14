package dsalgjava.ch13.progproj.pp1301;

public class BfsMstApp {

    public static void main(String[] args) {
        GraphBfsMst graph = new GraphBfsMst();
        graph.addVertex('A');   // 0
        graph.addVertex('B');   // 1
        graph.addVertex('C');   // 2
        graph.addVertex('D');   // 3
        graph.addVertex('E');   // 4
        graph.addVertex('F');   // 5
        graph.addVertex('G');   // 6
        graph.addVertex('H');   // 7
        graph.addVertex('I');   // 8
        
        graph.addEdge(0, 1); 
        graph.addEdge(0, 4);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 7);
        graph.addEdge(4, 8);
        graph.addEdge(5, 8);
        graph.addEdge(6, 8);

        System.out.print("Minimum spanning tree: ");
        graph.bfs();
        System.out.println();
    }

}
