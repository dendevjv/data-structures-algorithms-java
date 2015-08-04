package dsalgjava.ch11.shared;

public class DataItem {
    private int iData;
    
    public DataItem(int value) {
        iData = value;
    }
    
    public int getKey() {
        return iData;
    }
    
    @Override
    public String toString() {
        return Integer.toString(iData);
    }
}
