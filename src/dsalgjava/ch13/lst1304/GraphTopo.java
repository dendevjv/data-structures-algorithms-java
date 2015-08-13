package dsalgjava.ch13.lst1304;

import dsalgjava.ch13.lst1301.Graph;

/**
 * Demonstrates topological sorting.
 */
public class GraphTopo extends Graph {
    private char[] sortedArray;
    
    public GraphTopo() {
        super();
        sortedArray = new char[MAX_VERTS];
    }
    
    public void addEdgeDirected(int from, int to) {
        adjMat[from][to] = 1;
    }
    
    /**
     * Topological sort.
     */
    public void topo() {
        int orig_nVerts = nVerts;
        
        while (nVerts > 0) {
            int currentVertex = noSuccessors();
            if (currentVertex == -1) { // must be a cycle
                System.out.println("ERROR: Graph has cycles");
                return;
            }
            sortedArray[nVerts - 1] = vertexList[currentVertex].label;
            
            deleteVertex(currentVertex);
        }
        
        System.out.print("Topologically sorted order: ");
        for (int j = 0; j < orig_nVerts; j++) {
            System.out.print(sortedArray[j]);
        }
        System.out.println();
    }

    private void deleteVertex(int vertex) {
        if (vertex != nVerts - 1) {
            for (int j = vertex; j < nVerts - 1; j++) {
                vertexList[j] = vertexList[j + 1];
            }
            for (int row = vertex; row < nVerts - 1; row++) {
                moveRowUp(row, nVerts);
            }
            for (int col = vertex; col < nVerts - 1; col++) {
                moveColLeft(col, nVerts - 1);
            }
        }
        nVerts--;
    }

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }

    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }

    private int noSuccessors() {
        boolean hasSuccessor;
        for (int row = 0; row < nVerts; row++) {
            hasSuccessor = false;
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] > 0) {
                    hasSuccessor = true;
                    break;
                }
            }
            if (!hasSuccessor) {
                return row;
            }
        }
        return -1;
    }
}
