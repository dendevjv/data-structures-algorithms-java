package dsalgjava.ch07.progproj.pp0702;

import dsalgjava.ch03.shared.ArrayNonSorted;

public class ArrayQ2Counter extends ArrayNonSorted {
    private Counter copies = new Counter();
    private Counter comparisons = new Counter();

    public ArrayQ2Counter(int maxSize) {
        super(maxSize);
    }
    
    public ArrayQ2Counter(long[] values) {
        super(values);
    }

    public long getCopies() {
        return copies.getCount();
    }
    
    public long getComparisons() {
        return comparisons.getCount();
    }
    
    public void quickSort() {
        recQuickSort(0, nElems - 1);
    }
    
    protected void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1) {
            comparisons.incr();
            return;
        } else if (size <= 3) {
            comparisons.incr();
            manualSort(left, right);
        } else {
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }
    
    @Override
    protected void swap(int i, int j) {
        super.swap(i, j);
        copies.incr(3);
    }
    
    private void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1) {
            comparisons.incr();
            return;
        } else if (size == 2) {
            if (a[left] > a[right]) {
                comparisons.incr();
                swap(left, right);
            }
        } else {
            int c = left + 1;
            if (a[left] > a[c]) {
                comparisons.incr();
                swap(left, c);
            }
            if (a[c] > a[right]) {
                comparisons.incr();
                swap(c, right);
            }
            if (a[left] > a[c]) {
                comparisons.incr();
                swap(left, c);
            }
        }
    }
    
    protected int partitionIt(int left, int right, long pivot) {
        int i = left;
        int j = right - 1; // exclude rightmost item (pivot)
        while (true) {
            while (a[++i] < pivot) { // find bigger
                comparisons.incr();
            }
            while (a[--j] > pivot) { // find smaller
                comparisons.incr();
            }
            if (i >= j) {
                comparisons.incr();
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
            comparisons.incr();
            swap(left, center);
        }
        if (a[center] > a[right]) {
            comparisons.incr();
            swap(center, right);
        }
        if (a[left] > a[center]) {
            comparisons.incr();
            swap(left, center);
        }
        swap(center, right - 1);    // put pivot on right
        return a[right - 1];
    }
    
    private static class Counter {
        private long count = 0;
        
        public void incr() {
            count++;
        }
        
        public void incr(int n) {
            count += n;
        }
        
        public long getCount() {
            return count;
        }
    }
}
