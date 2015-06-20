package dsalgjava.ch03.progproj.pp0304;

import dsalgjava.ch03.shared.ArrayNonSorted;

public class ArrayOddEven extends ArrayNonSorted {

    public ArrayOddEven(int max) {
        super(max);
    }
    
    public ArrayOddEven(long[] initial) {
        super(initial);
    }
    
    public void oddEvenSort() {
        int passCount = 0;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < nElems - 1; i += 2) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                    swapped = true;
                }
            }
            for (int i = 1; i < nElems - 1; i += 2) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                    swapped = true;
                }
            }
            passCount++;
        } while (swapped);
        System.out.println("Made passes: " + passCount);
    }

}
