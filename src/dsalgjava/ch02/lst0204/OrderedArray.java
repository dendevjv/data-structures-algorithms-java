package dsalgjava.ch02.lst0204;

public class OrderedArray {
    private long[] a;
    private int nElems;
    
    public OrderedArray(int max) {
        a = new long[max];
        nElems = 0;
    }
    
    public int size() {
        return nElems;
    }
    
    public int find(long searchKey) {
        int lo = 0;
        int hi = nElems - 1;
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if (a[m] == searchKey) {
                return m;
            } else if (searchKey < a[m]) {
                hi = m - 1;
            } else {
                lo = m + 1;
            }
        }
        return -1;
    }
    
    public void insert(long value) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (a[i] >= value) {
                break;
            }
        }
        if (i < nElems) {
            for (int k = nElems; k > i; k--) {
                a[k] = a[k - 1];
            }
        }
        a[i] = value;
        nElems++;
    }
    
    public boolean delete(long value) {
        int j = find(value);
        if (j == -1) {
            return false;
        }
        for (int k = j; k < nElems - 1; k++) {
            a[k] = a[k + 1];
        }
        nElems--;
        return true;
    }
    
    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }
}
