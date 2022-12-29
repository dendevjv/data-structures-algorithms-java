package dsalgjava.ch13.lst1303;

import dsalgjava.ch13.lst1301.Graph;

/**
 * Graph implements minimum spanning tree.
 */
public class GraphMst extends Graph {
    /**
     * Minimum spanning tree (depth first).
     */
    public void mst() {
        vertexList[0].setVisited(true);
        stack.clear();
        stack.push(0);
        
        while (!stack.isEmpty()) {
            int currentVertex = stack.peek();
            int v = findAdjUnvisitedVertex(currentVertex);
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].setVisited(true);
                stack.push(v);
                
                displayVertex(currentVertex);
                displayVertex(v);
                System.out.print(' ');
            }
        }
        resetVisitedVerteces();
    }
}
