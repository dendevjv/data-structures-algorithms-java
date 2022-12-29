package dsalgjava.ch13.progproj.pp1302;

public class Vertex {
    public char label;
    public boolean visited;
    private VertexLinkList adjacencyList;
    
    public Vertex(char label) {
        this.label = label;
        visited = false;
        adjacencyList = new VertexLinkList();
    }
    
    public void addAdjacentVertex(Vertex v) {
        adjacencyList.add(v);
        v.adjacencyList.add(this);
    }
    
    public Vertex getAdjUnvisitedVertex() {
        return adjacencyList.getUnvisitedVertex();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
}
