package dsalgjava.ch13.progproj.pp1301;

import java.util.ArrayDeque;
import java.util.Queue;

import dsalgjava.ch13.lst1301.Graph;

/**
 * Graph finds minimum spanning tree using breadth-first search.
 */
public class GraphBfsMst extends Graph {
    private Queue<Integer> queue;
    
    GraphBfsMst() {
        queue = new ArrayDeque<>();
    }
    
    /**
     * Breadth-first search.
     */
    public void bfs() {
        vertexList[0].setVisited(true);
        queue.add(0);
        int v, v2;
        while (!queue.isEmpty()) {
            v = queue.remove();
            
            while ((v2 = findAdjUnvisitedVertex(v)) != -1) {
                vertexList[v2].setVisited(true);
                displayVertex(v);
                displayVertex(v2);
                System.out.print(' ');
                queue.add(v2);
            }
        }
        resetVisitedVerteces();
    }
}
