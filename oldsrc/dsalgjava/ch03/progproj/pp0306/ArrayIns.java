package dsalgjava.ch03.progproj.pp0306;

import dsalgjava.ch03.shared.ArrayNonSorted;

public class ArrayIns extends ArrayNonSorted {
    private final static long NON_EXISTING = -1;

    public ArrayIns(int max) {
        super(max);
    }
    
    public ArrayIns(long[] initial) {
        super(initial);
    }

    public void insertionSort() {
        for(int i = 1, j; i < nElems; i++) {
            long t = a[i];
            for (j = i; j > 0 && a[j - 1] > t; j--) {
                a[j] = a[j - 1];
            }
            // a[j - 1] <= t OR j == 0
            a[j] = t;
        }
    }
    
    public void insertionSortNoDupes() {
        boolean hasDupes = false;
        for(int i = 1, j; i < nElems; i++) {
            long t = a[i];
            for (j = i; j > 0 && a[j - 1] > t; j--) {
                a[j] = a[j - 1];
            }
            // PC: j == 0 OR a[j - 1] <= t
            if (j > 0 && a[j - 1] == t) {
                int k = j;
                while (k > 0 && a[k - 1] > NON_EXISTING) {
                    a[k] = a[k - 1];
                    k--;
                }
                // PC: k == 0 OR a[k - 1] <= NON_EXISTING
                a[k] = NON_EXISTING;
                hasDupes = true;
            }
            a[j] = t;
        }
        if (hasDupes) {
            int i = 0;
            while (i < nElems && a[i] == NON_EXISTING) {
                i++;
            }
            int k = 0;
            for (int j = i; j < nElems; j++) {
                a[k] = a[j];
                k++;
            }
            nElems = k;
        }
    }
    
    public void insertionSortWithArray() {
        long[] a2 = new long[a.length];
        a2[0] = a[0];
        
        int i = 1;
        int j;
        while (i < nElems) {
            long t = a[i];
            j = i;
            while (j > 0 && a2[j - 1] > t) {
                a2[j] = a2[j - 1];
                j--;
            }
            a2[j] = t;
            i++;
        }
        
        a = a2;
    }
}
