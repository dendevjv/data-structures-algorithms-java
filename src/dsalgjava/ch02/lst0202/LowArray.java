package dsalgjava.ch02.lst0202;

public class LowArray {
    private long[] a;
    
    public LowArray(int size) {
        a = new long[size];
    }
    
    public void set(int index, long value) {
        a[index] = value;
    }
    
    public long get(int index) {
        return a[index];
    }
}
