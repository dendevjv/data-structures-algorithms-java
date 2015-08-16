package dsalgjava.ch14.lst1402;

/**
 * Distance and parent vertex.
 */
public class DistPar {
    /**
     * Distance from start to this vertex
     */
    public int distance;
    /**
     * Current parent of this vertex.
     */
    public int parentVert;
    
    public DistPar(int parentVert, int distance) {
        this.parentVert = parentVert;
        this.distance = distance;
    }
}
