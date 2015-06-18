package dsalgjava.ch03.lst0302;

import dsalgjava.ch03.shared.ArrayNonSorted;

public class ArraySel extends ArrayNonSorted {

    public ArraySel(int max) {
        super(max);
    }
    
    public ArraySel(long[] array) {
        super(array);
    }

    public void selectionSort() {
        int iMin;
        for (int i = 0; i < nElems - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < nElems; j++) {
                if (a[j] < a[iMin]) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }
}
