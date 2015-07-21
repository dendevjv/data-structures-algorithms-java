package dsalgjava.ch07.lst0702;

import dsalgjava.ch03.shared.ArrayNonSorted;

public class ArrayPar extends ArrayNonSorted {

    public ArrayPar(int maxSize) {
        super(maxSize);
    }
    
    public ArrayPar(long[] values) {
        super(values);
    }

    /* Mine first attempt. */
    public int partitionIt(int left, int right, long pivot) {
        int i = left;
        int j = right;
        while (i < j) {
            if(a[i] > pivot && a[j] < pivot) {
                swap(i, j);
                i++;
                j--;
            } else if (a[i] <= pivot) {
                i++;
            } else {
                j--;
            }
        }
        return i;
    }
    
    /* Code from the Textbook. It is better, I suppose. */
    public int partitionIt2(int left, int right, long pivot) {
        int i = left - 1;
        int j = right + 1;
        while (true) {
            while (i < right && a[++i] < pivot) {
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
        return i;
    }
    
}
