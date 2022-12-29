package dsalgjava.ch07.lst0703;

import dsalgjava.ch03.shared.ArrayNonSorted;

public class ArrayQ extends ArrayNonSorted {
    private final static boolean DEBUG = false;

    public ArrayQ(int maxSize) {
        super(maxSize);
    }

    public ArrayQ(long[] values) {
        super(values);
    }

    public void quickSort() {
        recQuickSort(0, nElems - 1);
    }
    
    private void recQuickSort(int left, int right) {
        if (DEBUG) System.out.printf("enter recQuickSort(%d, %d)%n", left, right);
        if (right - left > 0) {
            long pivot = a[right];
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
        if (DEBUG) System.out.printf("exit recQuickSort(%d, %d)%n", left, right);
    }
    
    private int partitionIt(int left, int right, long pivot) {
        if (DEBUG) System.out.printf("enter partitionIt(%d, %d, %d)%n", left, right, pivot);
        if (DEBUG) {
            System.out.print("BP: ");
            display();
        }
        int i = left - 1;
        int j = right; // exclude rightmost item (pivot)
        while (true) {
            while (a[++i] < pivot) {
                ; // (nop)
            }
            while (j > left && a[--j] > pivot) {
                ; // (nop)
            }
            if (i >= j) {
                break;
            }
            swap(i, j);
        }
        swap(i, right); // restore pivot
        if (DEBUG) {
            System.out.print("AP: ");
            display();
        }
        if (DEBUG) System.out.printf("exit partitionIt(%d, %d, %d)%n", left, right, pivot);
        return i;
    }
}
