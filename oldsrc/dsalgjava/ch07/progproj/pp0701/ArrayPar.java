package dsalgjava.ch07.progproj.pp0701;

import dsalgjava.ch03.shared.ArrayNonSorted;

public class ArrayPar extends ArrayNonSorted {

    public ArrayPar(int maxSize) {
        super(maxSize);
    }
    
    public int partitionIt(int left, int right) {
        int i = left - 1;
        int j = right;
        long pivot = a[right];
        while (true) {
            while (a[++i] < pivot) {
                ; // (nop)
            }
            while (j > left && a[--j] > pivot) {
                ; // (nop)
            }
            if (i >= j) {
                break;
            } else {
                swap(i, j);
            }
        }
        swap(i, right);
        return i;
    }
    
}
