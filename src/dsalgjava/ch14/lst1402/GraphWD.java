package dsalgjava.ch14.lst1402;

import dsalgjava.ch14.lst1401.Vertex;

/**
 * Demonstrates shortest path with weighted, directed graph.
 */
public class GraphWD {
    protected final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    
    protected Vertex[] vertexList;
    protected int[][] adjMat;
    /**
     * Current number of vertices
     */
    protected int nVerts;
    /**
     * Number of vertices in tree.
     */
    private int nTree;
    /**
     * Array for shortest-path data
     */
    private DistPar sPath[];
    /**
     * Current vertex.
     */
    private int currentVert;
    /**
     * Distance to currentVert.
     */
    private int startToCurrent;
    
    public GraphWD() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        nTree = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = INFINITY;
            }
        }
        sPath = new DistPar[MAX_VERTS];
    }
    
    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }
    
    public void addEdgeDirected(int start, int end, int weight) {
        adjMat[start][end] = weight;
    }
    
    /**
     * Find all shortest paths.
     */
    public void path() {
        int startTree = 0;
        vertexList[startTree].setInTree(true);
        nTree = 1;
        
        // transfer row of distances from adjMat to sPath
        for (int j = 0; j < nVerts; j++) {
            int tempDist = adjMat[startTree][j];
            sPath[j] = new DistPar(startTree, tempDist);
        }
        
        // until all vertices are in the tree
        while (nTree < nVerts) {
            int indexMin = getMin();    
            int minDist = sPath[indexMin].distance;
            
            if (minDist == INFINITY) {
                System.out.println("There are unreachable vertices");
                break;
            } else {
                currentVert = indexMin;
                startToCurrent = sPath[indexMin].distance;
            }
            // put current vertex in tree
            vertexList[currentVert].setInTree(true);
            nTree++;
            adjust_sPath();
        }
        
        displayPaths();
        
        nTree = 0;      // clear tree
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].setInTree(false);
        }
    }

    private void displayPaths() {
        for (int j = 0; j < nVerts; j++) {
            System.out.print(vertexList[j].label + "=");
            if (sPath[j].distance == INFINITY) {
                System.out.print("inf");
            } else {
                System.out.print(sPath[j].distance);
            }
            char parent = vertexList[sPath[j].parentVert].label;
            System.out.print("(" + parent + ") ");
        }
        System.out.println();
    }

    /**
     * Update sPath array.
     */
    private void adjust_sPath() {
        // adjust values in shortest-path array sPath
        int column = 1;     // skip starting index
        while (column < nVerts) {
            // if this column's vertex already in tree, skip it
            if (vertexList[column].isInTree()) {
                column++;
                continue;
            }
            // calculate distance for one sPath entry
            // get edge from currentVert to column
            int currentToFringe = adjMat[currentVert][column];
            // add distance from start
            int startToFringe = startToCurrent + currentToFringe;
            // get distance of current sPath entry
            int sPathDist = sPath[column].distance;
            
            // compare distance from start with sPath entry
            if (startToFringe < sPathDist) {
                sPath[column].parentVert = currentVert;
                sPath[column].distance = startToFringe;
            }
            column++;
        }
    }

    /**
     * Get minimum from sPath.
     * @return index of minimum
     */
    private int getMin() {
        int minDist = INFINITY;
        int indexMin = 0;
        for (int j = 0; j < nVerts; j++) {
            if (!vertexList[j].isInTree() && sPath[j].distance < minDist) {
                minDist = sPath[j].distance;
                indexMin = j;
            }
        }
        return indexMin;
    }
}
