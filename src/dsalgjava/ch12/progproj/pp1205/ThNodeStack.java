package dsalgjava.ch12.progproj.pp1205;

import dsalgjava.ch12.progproj.pp1205.TreeHeap.ThNode;

public class ThNodeStack {
    private static final int DEFAULT_CAPACITY = 100;
    
    private ThNode[] arr;
    private int size;
    
    ThNodeStack() {
        this(DEFAULT_CAPACITY);
    }
    
    public ThNodeStack(int maxSize) {
        arr = new ThNode[maxSize];
        size = 0;
    }
    
    public void push(ThNode n) {
        arr[size++] = n;
    }
    
    public ThNode pop() {
        return arr[--size];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for  (int j = 0; j < size; j++) {
            if (j > 0) {
                sb.append(", ");
            }
            sb.append(arr[j]);
        }
        sb.append("]");
        return sb.toString();
    }
}
