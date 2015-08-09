package dsalgjava.ch12.lst1202;

import dsalgjava.ch12.lst1201.Heap;
import dsalgjava.ch12.shared.HpNode;

public class HeapSorting extends Heap {

    public HeapSorting(int maxSize) {
        super(maxSize);
    }
    
    @Override
    protected void trickleDown(int i) {
        super.trickleDown(i);
    }
    
    public void insertAt(int index, HpNode node) {
        heapArray[index] = node;
    }
    
    public void incrementSize() {
        size++;
    }

    /**
     * Displays all elements of inner array.
     */
    public void displayArray() {
        displayInnerArray(maxSize);
    }
    
}
