package dsalgjava.ch03.shared;

import java.util.Arrays;

public abstract class ArrayBase {
    protected long[] a;
    protected int nElems;
    
    public ArrayBase(int max) {
        a = new long[max];
        nElems = 0;
    }
    
    public ArrayBase(long[] array) {
        a = Arrays.copyOf(array, array.length);
        nElems = array.length;
    }
    
    public long get(int i) {
        return a[i];
    }
    
    public int getSize() {
        return nElems;
    }
    
    public long[] cloneInnerArray() {
        return Arrays.copyOf(a, nElems);
    }
    
    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }
    
    public abstract void insert(long value);
}
