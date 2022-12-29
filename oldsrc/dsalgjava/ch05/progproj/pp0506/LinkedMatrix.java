package dsalgjava.ch05.progproj.pp0506;

public class LinkedMatrix {
    private LinkM topLeft;
    private LinkM current;
    
    LinkedMatrix() {
        topLeft = null;
        current = null;
    }
    
    public void reset() {
        current = topLeft;
    }
    
    public LinkM getCurrent() {
        return current;
    }
    
    /**
     * Inserts new link left after <code>current</code> link.
     */
    public void insertRight(LinkM link) {
        if (topLeft == null) {
            topLeft = link;
            reset();
        } else {
            link.nextRight = current.nextRight;
            current.nextRight = link;
        }
    }
    
    /**
     * Inserts new link down after <code>current</code> link.
     */
    public void insertDown(LinkM link) {
        if (topLeft == null) {
            topLeft = link;
            reset();
        } else {
            link.nextDown = current.nextDown;
            current.nextDown = link;
        }
    }
    
    public void stepRight() {
        current = current.nextRight;
    }
    
    public void stepDown() {
        current = current.nextDown;
    }
    
    public void display() {
        LinkM r = topLeft;
        while (r != null) {
            LinkM c = r;
            while (c != null) {
                System.out.print(c + " ");
                c = c.nextRight;
            }
            System.out.println();
            r = r.nextDown;
        }
    }
}
