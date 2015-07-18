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
    
    public void set(int i, long value) {
        a[i] = value;
    }
    
    public int getCapacity() {
        return a.length;
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
    
    public void displayIndexed() {
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        for (int j = 0; j < nElems; j++) {
            line1.append(String.format("%" + ((int)Math.log10(a[j]) + 1) + "d", j));
            line1.append(" ");
            line2.append(a[j]);
            line2.append(" ");
        }
        System.out.println(line1);
        System.out.println(line2);
    }
    
    public abstract void insert(long value);
}
