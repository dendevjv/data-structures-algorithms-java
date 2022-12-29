package dsalgjava.ch02.progproj.pp0205;

import java.util.Arrays;

public class OrderedArray {
    private static final int NOT_FOUND = -1;
    private long[] a;
    private int nElems;
    
    /** Constructs new ordered array with specified maximum capacity. */
    public OrderedArray(int max) {
        a = new long[max];
        nElems = 0;
    }
    
    /**
     * Constructs new ordered array with specified maximum capacity.
     * @param max maximum capacity, must not be less than size of initial array
     * @param initialSorted sorted array of initial values
     */
    OrderedArray(int max, long[] initialSorted) {
        a = Arrays.copyOf(initialSorted, max);
        nElems = initialSorted.length;
    }
    
    /**
     * Constructs new ordered array from specified initial values
     * @param initial non sorted array of initial values
     */
    OrderedArray(long[] initial) {
        a = new long[initial.length];
        for (int i = 0; i < initial.length; i++) {
            insert(initial[i]);
        }
    }
    
    public int size() {
        return nElems;
    }
    
    public int find(long searchKey) {
        int lo = 0;
        int hi = nElems - 1;
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if (a[m] == searchKey) {
                return m;
            } else if (searchKey < a[m]) {
                hi = m - 1;
            } else {
                lo = m + 1;
            }
        }
        return NOT_FOUND;
    }
    
    public void insert(long value) {
        int insertIdx = NOT_FOUND;
        
        int lo = 0;
        int hi = nElems - 1;
        int middle;
        while (lo <= hi) {
            middle = lo + (hi - lo) / 2;
            if (a[middle] >= value 
                    && (middle == 0 || a[middle - 1] < value)) {
                insertIdx = middle;
                break;
            } else if (middle == nElems && a[middle - 1] < value) {
                insertIdx = middle;
                break;
            } else if (a[middle] < value) {
                lo = middle + 1;
            } else {
                hi = middle;
            }
        }
        if (insertIdx == NOT_FOUND) {
            insertIdx = nElems; // Will insert after last element
        }
        // Postconditions:
        // insertIdx == 0 OR a[insertIdx - 1] < value
        // insertIdx == nElems OR a[insertIdx] >= value
        
        // Shift elements to the right
        if (insertIdx < nElems) {    
            for (int k = nElems; k > insertIdx; k--) {
                a[k] = a[k - 1];
            }
        }
        
        a[insertIdx] = value;
        nElems++;
    }
    
    public boolean delete(long value) {
        int j = find(value);
        if (j == NOT_FOUND) {
            return false;
        }
        for (int k = j; k < nElems - 1; k++) {
            a[k] = a[k + 1];
        }
        nElems--;
        return true;
    }
    
    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }
    
    public boolean equalElements(OrderedArray arr2) {
        if (this.nElems != arr2.nElems) {
            return false;
        }
        for (int i = 0; i < nElems; i++) {
            if (a[i] != arr2.a[i]) {
                return false;
            }
        }
        return true;
    }
    
    public OrderedArray merge(OrderedArray other) {
        int length = this.size() + other.size();
        OrderedArray r = new OrderedArray(length);
        int i1 = 0, i2 = 0;
        for (int i = 0; i < length; i++) {
            if (i1 < nElems && i2 < other.nElems) {
                if (a[i1] < other.a[i2]) {
                    r.a[i] = a[i1];
                    i1++;
                } else {
                    r.a[i] = other.a[i2];
                    i2++;
                }
            } else if (i1 < nElems) {
                r.a[i] = a[i1];
                i1++;
            } else {
                r.a[i] = other.a[i2];
                i2++;
            }
        }
        r.nElems = length;
        return r;
    }
}
