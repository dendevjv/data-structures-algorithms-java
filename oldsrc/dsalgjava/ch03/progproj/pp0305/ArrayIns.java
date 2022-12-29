package dsalgjava.ch03.progproj.pp0305;

import dsalgjava.ch03.shared.ArrayNonSorted;

public class ArrayIns extends ArrayNonSorted {

    public ArrayIns(int max) {
        super(max);
    }
    
    public ArrayIns(long[] initial) {
        super(initial);
    }

    public void insertionSort() {
        Comparer comp1 = new Comparer();
        Comparer comp2 = new Comparer();
        Copier copier = new Copier(a);
        int i = 1;
        int j;
        while (i < nElems) {
            long t = a[i];
            j = i;
            while (comp1.greater(j, 0) && comp2.greater(a[j - 1], t)) {
                copier.copy(j, a[j - 1]);
                j--;
            }
            copier.copy(j, t);
            i++;
        }
        
        System.out.print("nElems: " + nElems);
        System.out.print("; i > 0 : " + comp1.getCount());
        System.out.print("; a[j - 1] > t : " + comp2.getCount());
        System.out.println("copies: " + copier.getCount());
    }
    
    private static class Copier {
        private long[] arr;
        private long count;
        
        Copier(long[] arr) {
            this.arr = arr;
        }
        
        void copy(int i, long value) {
            arr[i] = value;
            count++;
        }
        
        long getCount() {
            return count;
        }
    }
    
    private static class Comparer {
        private long count;
        
        boolean greater(long a, long b) {
            count++;
            return a > b;
        }
        
        long getCount() {
            return count;
        }
    }
}
