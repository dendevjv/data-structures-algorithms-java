package dsalgjava.ch03.lst0303;

import dsalgjava.ch03.shared.ArrayNonSorted;

public class ArrayIns extends ArrayNonSorted {

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
            a[j] = t;
        }
    }
}
