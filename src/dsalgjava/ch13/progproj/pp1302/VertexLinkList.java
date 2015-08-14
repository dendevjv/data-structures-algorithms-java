package dsalgjava.ch13.progproj.pp1302;

public class VertexLinkList {
    VertexLink first;

    public void add(Vertex v) {
        VertexLink link = new VertexLink(v);
        link.next = first;
        first = link;
    }

    public Vertex getUnvisitedVertex() {
        VertexLink current = first;
        while (current != null) {
            if (!current.vertex.isVisited()) {
                return current.vertex;
            }
            current = current.next;
        }
        return null;
    }
}
