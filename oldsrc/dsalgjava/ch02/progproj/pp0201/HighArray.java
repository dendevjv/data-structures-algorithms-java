package dsalgjava.ch02.progproj.pp0201;

public class HighArray {
    private long[] a;
    private int nElems;
    
    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == searchKey) {
                break;
            }
        }
        if (j == nElems) {
            return false;
        } else {
            return true;
        }
    }
    
    public void insert(long value) {
        a[nElems++] = value;
    }
    
    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == value) {
                break;
            }
        }
        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems - 1; k++) {
                a[k] = a[k + 1];
            }
            nElems--;
            return true;
        }
    }
    
    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }

    public long getMax() {
        if (nElems == 0) {
            return -1;
        }
        long max = Long.MIN_VALUE;
        for (int i = 0; i < nElems; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }
}
