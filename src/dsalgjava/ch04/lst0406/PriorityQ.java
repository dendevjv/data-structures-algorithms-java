package dsalgjava.ch04.lst0406;

public class PriorityQ {
    private int maxSize;
    private long[] queArr;
    private int nItems;
    
    public PriorityQ(int s) {
        maxSize = s;
        queArr = new long[maxSize];
        nItems = 0;
    }
    
    public void insert(long item) {
        int j = nItems;
        for (; j > 0 && queArr[j - 1] < item; j--) {
            queArr[j] = queArr[j - 1];
        }
        queArr[j] = item;
        nItems++;
    }
    
    public long remove() {
        return queArr[--nItems];
    }
    
    public long peekMin() {
        return queArr[nItems - 1];
    }
    
    public boolean isEmpty() {
        return nItems == 0;
    }
    
    public boolean isFull() {
        return nItems == maxSize;
    }
}
