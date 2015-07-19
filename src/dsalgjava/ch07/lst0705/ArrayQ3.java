package dsalgjava.ch07.lst0705;

import dsalgjava.ch07.lst0704.ArrayQ2;

/**
 * Quick sort using insertion sort for small partitions.
 */
public class ArrayQ3 extends ArrayQ2 {
    private int cutOff;

    public ArrayQ3(int maxSize, int cutOff) {
        super(maxSize);
        this.cutOff = cutOff;
    }

    public ArrayQ3(long[] values, int cutOff) {
        super(values);
        this.cutOff = cutOff;
    }

    protected void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1) {
            return;
        } else if (size < cutOff) {
            insertionSort(left, right);
        } else {
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    private void insertionSort(int left, int right) {
        long tmp;
        int inner;
        for (int outer = left + 1; outer <= right; outer++) {
            inner = outer;
            tmp = a[inner];
            while (inner > left && a[inner - 1] > tmp) {
                a[inner] = a[inner - 1];
                inner--;
            }
            a[inner] = tmp;
        }
    }
}
