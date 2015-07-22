package dsalgjava.ch07.progproj.pp0705;

import dsalgjava.ch03.shared.ArrayNonSorted;
import dsalgjava.tools.LongTools;


/**
 * Uses radix sorting.
 */
public class ArrayRadix extends ArrayNonSorted {

    public ArrayRadix(int maxSize) {
        super(maxSize);
    }

    public ArrayRadix(long[] values) {
        super(values);
    }

    public void radixSort() {
        long[] src = a;
        long[] dst = new long[a.length];
        long[] t;
        long mask = 1;
        int k;
//        int bits = Long.SIZE;
        int bits = findMaxBits();;
        for (int i = 0; i < bits; i++) {
            k = 0;
            for (int j = 0; j < nElems; j++) {
                if ((src[j] & mask) == 0) {
                    dst[k++] = src[j];
                }
            }
            for (int j = 0; j < nElems; j++) {
                if ((src[j] & mask) == mask) {
                    dst[k++] = src[j];
                }
            }
            
            t = src;
            src = dst;
            dst = t;
            mask = mask << 1;
        }
        if (a != src) {
            a = src;
        }
    }

    private int findMaxBits() {
        long max = maximum();
        return LongTools.numBits(max);
    }
}
