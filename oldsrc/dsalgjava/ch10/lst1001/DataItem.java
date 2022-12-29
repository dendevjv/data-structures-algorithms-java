package dsalgjava.ch10.lst1001;

public class DataItem {
    public long dData;
    
    public DataItem(long dd) {
        dData = dd;
    }
    
    public void display() {
        System.out.print("/" + dData);
    }
}
