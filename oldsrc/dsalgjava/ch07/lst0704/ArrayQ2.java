package dsalgjava.ch07.lst0704;

import dsalgjava.ch03.shared.ArrayNonSorted;

public class ArrayQ2 extends ArrayNonSorted {

    public ArrayQ2(int maxSize) {
        super(maxSize);
    }
    
    public ArrayQ2(long[] values) {
        super(values);
    }

    public void quickSort() {
        recQuickSort(0, nElems - 1);
    }
    
    protected void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1) {
            return;
        } else if (size <= 3) {
            manualSort(left, right);
        } else {
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }
    
    private void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1) {
            return;
        } else if (size == 2) {
            if (a[left] > a[right]) {
                swap(left, right);
            }
        } else {
            int c = left + 1;
            if (a[left] > a[c]) {
                swap(left, c);
            }
            if (a[c] > a[right]) {
                swap(c, right);
            }
            if (a[left] > a[c]) {
                swap(left, c);
            }
        }
    }
    
    protected int partitionIt(int left, int right, long pivot) {
        int i = left;
        int j = right - 1; // exclude rightmost item (pivot)
        while (true) {
            while (a[++i] < pivot) { // find bigger
                ; // (nop)
            }
            while (a[--j] > pivot) { // find smaller
                ; // (nop)
            }
            if (i >= j) {
                break;
            }
            swap(i, j);
        }
        swap(i, right - 1); // restore pivot
        return i; // return pivot location
    }
    
    protected long medianOf3(int left, int right) {
        int center = left + (right - left) / 2;
        if (a[left] > a[center]) {
            swap(left, center);
        }
        if (a[center] > a[right]) {
            swap(center, right);
        }
        if (a[left] > a[center]) {
            swap(left, center);
        }
        swap(center, right - 1);    // put pivot on right
        return a[right - 1];
    }
}
