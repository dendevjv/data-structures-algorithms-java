package dsalgjava.ch04.progproj.pp0405;

import dsalgjava.ch04.lst0404.Queue;

public class Line {
    private static final int MAX_SIZE = 50;
    private int id;
    private Queue queue;
    
    public Line(int id) {
        this.id = id;
        queue = new Queue(MAX_SIZE);
    }
    
    public void add(long v) {
        queue.insert(v);
    }
    
    public long remove() {
        return queue.remove();
    }
    
    public int length() {
        return queue.getSize();
    }
    
    @Override
    public String toString() {
        return "Line #" + id + ": " + queue;
    }
}
