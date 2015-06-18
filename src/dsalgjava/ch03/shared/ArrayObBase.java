package dsalgjava.ch03.shared;

import java.util.Arrays;

public abstract class ArrayObBase<E> {
    protected E[] a;
    protected int nElems;
    
    protected ArrayObBase() {
    }
    
    protected ArrayObBase(E[] array) {
        a = Arrays.copyOf(array, array.length);
        nElems = array.length;
    }
    
    public E[] cloneInnerArray() {
        return Arrays.copyOf(a, nElems);
    }
    
    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.println(a[j]);
        }
    }
    
    public void insert(E item) {
        a[nElems++] = item;
    }
}
