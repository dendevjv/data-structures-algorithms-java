package dsalgjava.ch05.lst0504;

import dsalgjava.ch05.lst0503.FirstLastList;
import dsalgjava.ch05.lst0503.Link;

/**
 * Stack implemented as linked list.
 */
public class LinkStack {
    private FirstLastList list;
    
    public LinkStack() {
        list = new FirstLastList();
    }
    
    public void push(long v) {
        list.insertFirst(new Link(v));
    }
    
    public long pop() {
        return list.deleteFirst().data;
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public void display() {
        list.display("Stack (top-->bottom): ");
    }
}
