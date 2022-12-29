package dsalgjava.ch02.progproj.pp0206;

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
    
    private static final long DUP_MARKER = -1;
    
    /** Removes all duplicate values. */
    public void noDups() {
        // Find and mark all duplicates
        for (int i = 0; i < nElems; i++) {
            long current = a[i];
            for (int j = 0; j < nElems; j++) {
                if (j != i && a[j] == current) {
                    a[j] = DUP_MARKER;
                }
            }
        }
        
        // Remove duplicates
        long[] a2 = new long[a.length];
        int nElems2 = 0;
        int j = 0;
        for (int i = 0; i < nElems; i++) {
            if (a[i] != DUP_MARKER) {
                a2[j++] = a[i];
                nElems2++;
            }
        }
        a = a2;
        nElems = nElems2;
    }
    
    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }
}
