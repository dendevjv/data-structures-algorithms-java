package dsalgjava.ch05.progproj.pp0501;

import dsalgjava.ch05.lst0503.Link;
import dsalgjava.ch05.lst0506.SortedList;

public class PriorityQueue {
    private SortedList sorted;
    
    public PriorityQueue() {
        sorted = new SortedList();
    }
    
    public void add(long value) {
        sorted.insert(new Link(value));
    }
    
    public long remove() {
        return sorted.remove().data;
    }
    
    public void display() {
        sorted.display("Priority Queue: ");
    }
}
