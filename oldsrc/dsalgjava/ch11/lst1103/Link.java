package dsalgjava.ch11.lst1103;

public class Link  {
    private int iData;
    public Link next;
    
    public Link(int key) {
        iData = key;
    }
    
    public int getKey() {
        return iData;
    }
    
    public void display() {
        System.out.print(iData + " ");
    }
}
