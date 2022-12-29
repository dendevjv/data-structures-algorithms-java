package dsalgjava.ch04.progproj.pp0404;

public class PriorityQueueSlowRemove {
    private int size;
    private long[] arr;
    private boolean sorted;
    
    public PriorityQueueSlowRemove(int maxSize) {
        arr = new long[maxSize];
        size = 0;
        sorted = false;
    }
    
    public void add(long v) {
        arr[size++] = v;
        if (size > 1 && arr[size - 1] > arr[size - 2]) {
            sorted = false;
        }
    }
    
    public long remove() {
        if (!sorted) {
            System.out.println("sorting...");
            for (int j = 1; j < size; j++) {
                long t = arr[j];
                int i = j;
                while ( i > 0 && arr[i - 1] < t) {
                    arr[i] = arr[i - 1];
                    i--;
                }
                // i == 0 OR arr[i - 1] >= t
                arr[i] = t;
            }
            sorted = true;
        }
        return arr[--size];
    }
    
    public int getSize() {
        return size;
    }
    
    public void display() {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.println("  size:" + size);
        for (int i = 0; i < arr.length; i++) {
            if (i == size - 1) {
                System.out.print(" ^S");
            } else {
                System.out.print("   ");
            }
        }
        System.out.println();
    }
}
