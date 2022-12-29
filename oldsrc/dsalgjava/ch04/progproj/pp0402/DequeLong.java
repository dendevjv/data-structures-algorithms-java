package dsalgjava.ch04.progproj.pp0402;

public class DequeLong {
    private int size;
    private long[] arr;
    private int left;
    private int right;
    
    public DequeLong(int maxSize) {
        arr = new long[maxSize];
        size = 0;
        left = 0;
        right = -1;
    }
    
    public void insertLeft(long v) {
        checkInsert();
        left--;
        if (left < 0) {
            left = arr.length - 1;
        }
        arr[left] = v;
        size++;
        if (size == 1) {
            right = left;
        }
    }
    
    public void insertRight(long v) {
        checkInsert();
        right++;
        if (right >= arr.length) {
            right = 0;
        }
        arr[right] = v;
        size++;
        if (size == 1) {
            left = right;
        }
    }
    
    
    public long removeLeft() {
        checkRemove();
        long v = arr[left];
        left++;
        if (left >= arr.length) {
            left = 0;
        }
        size--;
        return v;
    }
    
    public long removeRight() {
        checkRemove();
        long v = arr[right];
        right--;
        if (right < 0) {
            right = arr.length - 1;
        }
        size--;
        return v;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == arr.length;
    }

    private void checkInsert() {
        if (isFull()) {
            throw new IllegalStateException("Cannot insert when the deque is full");
        }
    }
    
    private void checkRemove() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove when the deque is empty");
        }
    }
}
