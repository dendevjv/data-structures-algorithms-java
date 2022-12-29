package dsalgjava.ch12.progproj.pp1202;

import dsalgjava.ch12.shared.HpNode;

public class HeapToss {
    protected HpNode[] heapArray;
    protected int maxSize;
    protected int size;
    
    public HeapToss(int maxSize) {
        this.maxSize = maxSize;
        heapArray = new HpNode[maxSize];
        size = 0;
    }
    
    public boolean insert(int key) {
        if (size == maxSize) {
            return false;
        }
        HpNode n = new HpNode(key);
        heapArray[size] = n;
        trickleUp(size++);
        return true;
    }
    
    /**
     * Adds a new node to the heap without ensuring the heap condition.
     * The heap condition must be restored with method <code>restoreHeap()</code>. 
     */
    public boolean toss(int key) {
        if (size == maxSize) {
            return false;
        }
        heapArray[size++] = new HpNode(key);
        return true;
    }
    
    public void restoreHeap() {
        for (int i = (size - 1) / 2; i >= 0; i--) {
            trickleDown(i);
        }
    }
    
    public HpNode remove() {
        if (size == 0) {
            return null;
        }
        HpNode root = heapArray[0];
        heapArray[0] = heapArray[--size];
        trickleDown(0);
        return root;
    }
    
    public boolean change(int index, int newValue) {
        if (index < 0 || index >= size) {
            return false;
        }
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        if (oldValue < newValue) {
            trickleUp(index);
        } else {
            trickleDown(index);
        }
        return true;
    }

    protected void trickleDown(int i) {
        HpNode top = heapArray[i];
        int left, right, larger;
        while (i < size / 2) {
            left = getLeftChild(i);
            right = getRightChild(i);
            if (right < size 
                    && heapArray[right].getKey() > heapArray[left].getKey()) {
                larger = right;
            } else {
                larger = left;
            }
            if (top.getKey() > heapArray[larger].getKey()) {
                break;
            }
            heapArray[i] = heapArray[larger];
            i = larger;
        }
        heapArray[i] = top;
    }
    
    /**
     * Displays specified number of elements of inner array.
     * @param arraySize number of elements to display
     */
    protected void displayInnerArray(int arraySize) {
        for (int m = 0; m < arraySize; m++) {
            if (heapArray[m] != null) {
                System.out.print(heapArray[m].getKey() + " ");
            } else {
                System.out.println("-- ");
            }
        }
        System.out.println();
    }
    
    /**
     * Displays elements of inner array and displays heap as a tree.
     */
    public void display() {
        displayInnerArray(size);
        
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................";
        System.out.println(dots + dots);
        
        while (size > 0) {
            if (column == 0) {
                for (int k = 0; k < nBlanks; k++) {
                    System.out.print(' ');
                }
            }
            System.out.print(heapArray[j].getKey());
            if (++j == size) {
                break;
            }
            
            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(' '); // interim blanks
                }
            }
        }
        System.out.println("\n" + dots + dots);
    }
    

    private int getRightChild(int index) {
        return index * 2 + 2;
    }

    private int getLeftChild(int index) {
        return index * 2 + 1;
    }

    private void trickleUp(int index) {
        HpNode bottom = heapArray[index];
        int key = bottom.getKey();
        
        int parent = getParent(index);
        while (index > 0 && heapArray[parent].getKey() < key) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = getParent(parent);
        }
        heapArray[index] = bottom;
    }
    
    private final int getParent(int index) {
        return (index - 1) / 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
