package dsalgjava.ch13.lst1301;

import java.util.ArrayDeque;
import java.util.Deque;

public class Graph {
    private final int MAX_VERTS = 20;
    
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private Deque<Integer> stack;
    
    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        stack = new ArrayDeque<>();
    }
    
    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }
    
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
    
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }
    
    /**
     * Depth-first search.
     */
    public void dfs() {
        vertexList[0].setVisited(true);
        displayVertex(0);
        stack.push(0);
        
        while (!stack.isEmpty()) {
            int v = findAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].setVisited(true);
                displayVertex(v);
                stack.push(v);
            }
        }
        System.out.println();
        resetVisited();
    }

    private void resetVisited() {
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].setVisited(false);
        }
    }

    private int findAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && !vertexList[j].isVisited()) {
                return j;
            }
        }
        return -1;
    }
}
