package dsalgjava.ch05.lst0501;

public class Link {
    public int iData;
    public double dData;
    public Link next;
    
    public Link(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }
    
    public void display() {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}
