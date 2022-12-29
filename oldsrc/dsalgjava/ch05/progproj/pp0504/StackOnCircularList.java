package dsalgjava.ch05.progproj.pp0504;

import dsalgjava.ch05.lst0503.Link;
import dsalgjava.ch05.progproj.pp0503.CircularList;

public class StackOnCircularList {
    private CircularList list = new CircularList();
    
    public void push(long v) {
        list.insert(new Link(v));
    }
    
    public long pop() {
        return list.delete().data;
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
