package dsalgjava.ch05.lst0503;

public class Link {
    public long data;
    public Link next;
    
    public Link(long data) {
        this.data = data;
    }
    
    public void display() {
        System.out.print(data + " ");
    }
    
    @Override
    public String toString() {
        return Long.toString(data);
    }
}
