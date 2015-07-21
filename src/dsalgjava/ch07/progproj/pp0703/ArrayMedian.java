package dsalgjava.ch07.progproj.pp0703;

import dsalgjava.ch03.shared.ArrayNonSorted;
import dsalgjava.tools.ArrayTools;

public class ArrayMedian extends ArrayNonSorted {
    private int middle;

    public ArrayMedian(int maxSize) {
        super(maxSize);
    }
    
    public ArrayMedian(String stringOfValues) {
        super(ArrayTools.stringToLongArray(stringOfValues));
    }
    
    public int partitionAndFindMedian() {
        int left = 0;
        int right = getSize() - 1;
        middle = left + (right - left) / 2;
        int partition;
        do {
            partition = partitionIt(left, right);
            if (partition == middle) {
                return partition;
            } else {
                if (partition < middle) {
                    left = partition;
//                    right = getSize() - 1;
                } else {
//                    left = 0;
                    right = partition;
                }
            }
        } while (true);
    }
    
    public int partitionIt(int left, int right) {
        int i = left - 1;
        int j = right + 1;
        long pivot = a[middle];
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
        return i;
    }
    
}
