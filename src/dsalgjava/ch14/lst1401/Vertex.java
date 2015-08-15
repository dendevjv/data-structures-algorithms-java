package dsalgjava.ch14.lst1401;

public class Vertex {
    public char label;
    public boolean inTree;
    
    public Vertex(char label) {
        this.label = label;
        inTree = false;
    }

    public boolean isInTree() {
        return inTree;
    }

    public void setInTree(boolean inTree) {
        this.inTree = inTree;
    }
    
}
