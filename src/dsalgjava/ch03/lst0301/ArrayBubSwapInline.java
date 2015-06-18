package dsalgjava.ch03.lst0301;

import dsalgjava.ch03.shared.ArrayBase;

/**
 * Clone of class ArrayBub without method swap (code moved into method bubbleSort) -
 * it does not show any gains in speed.
 */
public class ArrayBubSwapInline extends ArrayBase {

    public ArrayBubSwapInline(int max) {
        super(max);
    }
    
    public ArrayBubSwapInline(long[] array) {
        super(array);
    }

    @Override
    public void insert(long value) {
        a[nElems++] = value;
    }

    public void bubbleSort() {
        int next;
        long t;
        for (int sorted = nElems - 1; 
                sorted > 0; // Error found. Was: sorted > 1, Fixed: sorted > 0
                sorted--) {
            for (int i = 0; i < sorted; i++) {
                next = i + 1;
                if (a[i] > a[next]) {
                    t = a[i];
                    a[i] = a[next];
                    a[next] = t;
                }
            }
        }
    }
}
