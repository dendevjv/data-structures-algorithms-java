package dsalgjava.ch12.progproj.pp1203;

import dsalgjava.ch12.lst1201.Heap;

public class PriorityQueueHeap {
    private Heap heap;
    
    public PriorityQueueHeap(int maxSize) {
        heap = new Heap(maxSize);
    }
    
    public void insert(int value) {
        heap.insert(value);
    }
    
    public int remove() {
        return heap.remove().getKey();
    }
    
    public int peekMin() {
        return heap.peekMinimum();
    }
    
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
    public boolean isFull() {
        return heap.isFull();
    }
}
