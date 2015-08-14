package dsalgjava.ch13.progproj.pp1303;

public class GraphConnectivityTableApp {

    public static void main(String[] args) {
        GraphConnectivityTable graph = new GraphConnectivityTable();
        
        graph.addVertex('A'); // 0
        graph.addVertex('B'); // 1
        graph.addVertex('C'); // 2
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4
        
        graph.addEdgeDirected(1, 0);
        graph.addEdgeDirected(0, 2);
        graph.addEdgeDirected(1, 4);
        graph.addEdgeDirected(3, 4);
        graph.addEdgeDirected(4, 2);
        
        for (int start = 0; start < 5; start++) {
            graph.dfs(start);
        }
    }

}
