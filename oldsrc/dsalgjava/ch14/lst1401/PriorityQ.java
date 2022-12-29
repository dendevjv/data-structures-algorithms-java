package dsalgjava.ch14.lst1401;

public class PriorityQ {
    private final static int SIZE = 20;
    
    private Edge[] queArray;
    private int size;
    
    public PriorityQ() {
        queArray = new Edge[SIZE];
        size = 0;
    }
    
    public void insert(Edge item) {
        int i = size;
        while (i > 0 && queArray[i - 1].distance < item.distance) {
            queArray[i] = queArray[i - 1];
            i--;
        }
        queArray[i] = item;
        size++;
    }
    
    public Edge remove() {
        return queArray[--size];
    }
    
    public Edge peek() {
        return queArray[size];
    }
    
    public Edge peekN(int n) {
        return queArray[n];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void deleteN(int n) {
        for (int i = n; i < size - 1; i++) {
            queArray[i] = queArray[i + 1];
        }
        size--;
    }
    
    /**
     * Find item with specified destination vertex value.
     * @param findDest destination vertex value
     * @return index of found item or -1
     */
    public int find(int findDest) {
        for (int j = 0; j < size; j++) {
            if (queArray[j].destVert == findDest) {
                return j;
            }
        }
        return -1;
    }
}
