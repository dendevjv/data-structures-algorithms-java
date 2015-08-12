package dsalgjava.ch13.lst1302;

import java.util.ArrayDeque;
import java.util.Queue;

import dsalgjava.ch13.lst1301.Graph;

/**
 * Graph implements breadth-first search.
 */
public class GraphBfs extends Graph {
    private Queue<Integer> queue;
    
    GraphBfs() {
        queue = new ArrayDeque<>();
    }
    
    /**
     * Breadth-first search.
     */
    public void bfs() {
        vertexList[0].setVisited(true);
        displayVertex(0);
        queue.add(0);
        int v, v2;
        while (!queue.isEmpty()) {
            v = queue.remove();
            
            while ((v2 = findAdjUnvisitedVertex(v)) != -1) {
                vertexList[v2].setVisited(true);
                displayVertex(v2);
                queue.add(v2);
            }
        }
        resetVisitedVerteces();
    }
}
