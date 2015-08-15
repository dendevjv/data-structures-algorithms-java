package dsalgjava.ch14.lst1401;

/**
 * Demonstrates minimum spanning tree with weighted graphs.
 */
public class GraphMstw {
    protected final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    
    protected Vertex[] vertexList;
    protected int[][] adjMat;
    protected int nVerts;   // current number of vertices
    private int currentVert;
    private PriorityQ thePQ;
    private int nTree;      // number of vertices in tree
    
    public GraphMstw() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = INFINITY;
            }
        }
        thePQ = new PriorityQ();
    }
    
    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }
    
    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
        adjMat[end][start] = weight;
    }
    
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }
    
    /**
     * Minimum spanning tree with weighted graphs.
     */
    public void mstw() {
        nTree = 0;
        currentVert = 0;
        
        while (nTree < nVerts - 1) {
            vertexList[currentVert].setInTree(true);
            nTree++;
            
            // insert edges adjacent to currentVert into PQ
            for (int j = 0; j < nVerts; j++) {
                if (j == currentVert || vertexList[j].isInTree()) {
                    continue;
                }
                int distance = adjMat[currentVert][j];
                if (distance == INFINITY) { // skip if no edge
                    continue;
                }
                putInPQ(j, distance);
            }
            if (thePQ.isEmpty()) {
                System.out.println(" GRAPH NOT CONNECTED");
                return;
            }
            // remove edge with minimum distance, from PQ
            Edge minimumEdge = thePQ.remove();
            int sourceVert = minimumEdge.srcVert;
            currentVert = minimumEdge.destVert;
            
            // display edge from source to current
            System.out.print(vertexList[sourceVert].label);
            System.out.print(vertexList[currentVert].label);
            System.out.print(' ');
        } // end while
        
        // mst is complete
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].setInTree(false);
        }
    } // end mstw()

    private void putInPQ(int newVert, int newDist) {
        // is there another edge with the same destination vertex?
        int queueIndex = thePQ.find(newVert);
        if (queueIndex != -1) {
            Edge tempEdge = thePQ.peekN(queueIndex);
            int oldDist = tempEdge.distance;
            if (oldDist > newDist) {
                thePQ.deleteN(queueIndex);
                Edge theEdge = new Edge(currentVert, newVert, newDist);
                thePQ.insert(theEdge);
            } // else no action - leave old vertex there
        }
        else { // no edge with same destination vertex
            Edge theEdge = new Edge(currentVert, newVert, newDist);
            thePQ.insert(theEdge);
        }
    }

}
