package dsalgjava.ch05.lst0508;

public class LinkD {
    public long data;
    public LinkD next;
    public LinkD prev;
    
    public LinkD(long data) {
        this.data = data;
    }
    
    public void display() {
        System.out.print(data + " ");
    }
}
