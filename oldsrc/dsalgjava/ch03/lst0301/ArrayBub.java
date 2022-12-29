package dsalgjava.ch03.lst0301;

import dsalgjava.ch03.shared.ArrayNonSorted;

public class ArrayBub extends ArrayNonSorted {

    public ArrayBub(int max) {
        super(max);
    }
    
    public ArrayBub(long[] array) {
        super(array);
    }

    public void bubbleSort() {
        int next;
        for (int sorted = nElems - 1; 
                sorted > 0; // Error found. Was: sorted > 1, Fixed: sorted > 0
                sorted--) {
            for (int i = 0; i < sorted; i++) {
                next = i + 1;
                if (a[i] > a[next]) {
                    swap(i, next);
                }
            }
        }
    }

}
