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
        int maxLength = numberLength(maximum());
        String formatStr = "%" + (1 + maxLength) + "d";
        for (int j = 0; j < nElems; j++) {
            line1.append(String.format(formatStr, j));
            line2.append(String.format(formatStr, a[j]));
        }
        System.out.println(line1);
        System.out.println(line2);
    }
    
    private static int numberLength(long v) {
        if (v == 0) {
            return 1;
        }
        if (v < 0) {
            return numberLength(-v) + 1;
        }
        int len = 0;
        while (v != 0) {
            v /= 10;
            len++;
        }
        return len;
    }
    
    public long maximum() {
        long max = Long.MIN_VALUE;
        for (long n : a) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }
    
    public abstract void insert(long value);
}
