package dsalgjava.ch06.lst0603;

public class OrdArray {
    private long[] a;
    private int nElems;
    
    public OrdArray(int maxSize) {
        a = new long[maxSize];
        nElems = 0;
    }
    
    public int size() {
        return nElems;
    }
    
    public int find(long key) {
        return recFind(key, 0, nElems - 1);
    }
    
    private int recFind(long key, int lowerBound, int upperBound) {
        int current = (lowerBound + upperBound) / 2;
        if (a[current] == key) {
            return current;
        } else if (lowerBound > upperBound) {
            return nElems;
        } else {
            if (a[current] < key) {
                return recFind(key, current + 1, upperBound);
            } else {
                return recFind(key, lowerBound, current - 1);
            }
        }
    }
    
    public void insert(long v) {
        int j = nElems;
        for (; j > 0 && a[j - 1] > v; j--) {
            a[j] = a[j - 1];
        }
        a[j] = v;
        nElems++;
    }
    
    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }
    
    public void displayIndexed() {
        for (int j = 0; j < nElems; j++) {
            System.out.printf("%4d", j);
        }
        System.out.println();
        for (int j = 0; j < nElems; j++) {
            System.out.printf("%4d", a[j]);
        }
        System.out.println();
    }
}
