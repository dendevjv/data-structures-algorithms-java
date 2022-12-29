package dsalgjava.ch14.lst1401;

public class Edge {
    public int srcVert;
    public int destVert;
    public int distance;
    
    public Edge(int source, int destination, int dist) {
        srcVert = source;
        destVert = destination;
        distance = dist;
    }
}
