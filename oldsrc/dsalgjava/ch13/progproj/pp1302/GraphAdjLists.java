package dsalgjava.ch13.progproj.pp1302;

import java.util.ArrayDeque;
import java.util.Deque;

public class GraphAdjLists {
    protected final int MAX_VERTS = 20;
    
    protected Vertex[] vertexList;
    protected int[][] adjMat;
    protected int nVerts;
    protected Deque<Vertex> stack;
    
    public GraphAdjLists() {
        vertexList = new Vertex[MAX_VERTS];
        nVerts = 0;
        stack = new ArrayDeque<>();
    }
    
    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }
    
    public void addEdge(int start, int end) {
        vertexList[start].addAdjacentVertex(vertexList[end]);
    }
    
    public void displayVertex(Vertex v) {
        System.out.print(v.label);
    }
    
    /**
     * Depth-first search.
     */
    public void dfs() {
        vertexList[0].setVisited(true);
        displayVertex(vertexList[0]);
        stack.push(vertexList[0]);
        
        while (!stack.isEmpty()) {
            Vertex v = stack.peek().getAdjUnvisitedVertex();
            if (v == null) {
                stack.pop();
            } else {
                v.setVisited(true);
                displayVertex(v);
                stack.push(v);
            }
        }
        System.out.println();
        resetVisitedVerteces();
    }

    protected void resetVisitedVerteces() {
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].setVisited(false);
        }
    }
}
