package dsalgjava.ch03.progproj.pp0303;

import dsalgjava.ch03.lst0303.ArrayIns;

public class ArrayInsP3 extends ArrayIns {

    public ArrayInsP3(int max) {
        super(max);
    }

    public ArrayInsP3(long[] initial) {
        super(initial);
    }

    /**
     * Removes duplicate elements.
     */
    public void noDups() {
        int dest = 0;
        for (int source = 1 ; source < nElems; source++) {
            if (a[dest] != a[source]) {
                a[++dest] = a[source];
            }
        }
        nElems = dest + 1;
    }

    public ArrayInsP3 noDupsCopy() {
        ArrayInsP3 arr = new ArrayInsP3(this.a.length);
        int sourceIdx = 0;
        int destIdx = 0;
        
        arr.a[destIdx] = a[sourceIdx];
        sourceIdx++;
        
        while (sourceIdx < nElems) {
            if (arr.a[destIdx] != a[sourceIdx]) {
                arr.a[++destIdx] = a[sourceIdx];
            }
            sourceIdx++;
        }
        arr.nElems = destIdx + 1;
        return arr;
    }
}
