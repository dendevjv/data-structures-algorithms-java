package dsalgjava.ch02.progproj.pp0204;

import java.util.Arrays;

public class OrderedArray {
    private static final int NOT_FOUND = -1;
    private long[] a;
    private int nElems;
    
    public OrderedArray(int max) {
        a = new long[max];
        nElems = 0;
    }
    
    OrderedArray(int max, long[] initial) {
        a = Arrays.copyOf(initial, max);
        nElems = initial.length;
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
}
