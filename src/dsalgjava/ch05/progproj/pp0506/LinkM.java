package dsalgjava.ch05.progproj.pp0506;

public class LinkM {
    public long data;
    public LinkM nextRight;
    public LinkM nextDown;
    
    public LinkM(long value) {
        data = value;
    }
    
    @Override
    public String toString() {
        return Long.toString(data);
    }
}
