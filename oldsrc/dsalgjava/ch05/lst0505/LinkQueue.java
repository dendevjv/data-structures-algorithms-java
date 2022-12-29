package dsalgjava.ch05.lst0505;

import dsalgjava.ch05.lst0503.FirstLastList;
import dsalgjava.ch05.lst0503.Link;

public class LinkQueue {
    private FirstLastList list;
    
    public LinkQueue() {
        list = new FirstLastList();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public void insert(long v) {
        list.insertLast(new Link(v));
    }
    
    public long remove() {
        return list.deleteFirst().data;
    }
    
    public void display() {
        list.display("Queue (front-->rear): ");
    }
}
