package dsalgjava.ch03.shared;

public class ArrayNonSorted extends ArrayBase {

    public ArrayNonSorted(int max) {
        super(max);
    }
    
    public ArrayNonSorted(long[] array) {
        super(array);
    }

    @Override
    public void insert(long value) {
        a[nElems++] = value;
    }

    protected void swap(int i, int j) {
        long t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
