package dsalgjava.ch13.lst1301;

public class Vertex {
    public char label;
    public boolean visited;
    
    public Vertex(char label) {
        this.label = label;
        visited = false;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
}
