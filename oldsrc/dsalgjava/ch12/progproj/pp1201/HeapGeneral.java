package dsalgjava.ch12.progproj.pp1201;

import java.util.Comparator;

import dsalgjava.ch12.shared.HpNode;

public class HeapGeneral {
    protected HpNode[] heapArray;
    protected int maxSize;
    protected int size;
    private Comparator<HpNode> comparator;
    
    public HeapGeneral(int maxSize, Comparator<HpNode> comparator) {
        this.maxSize = maxSize;
        this.comparator = comparator;
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
        HpNode oldNode = heapArray[index];
        HpNode newNode = new HpNode(newValue);
        heapArray[index] = newNode;
        if (comparator.compare(oldNode, newNode) < 0) {
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
                    && comparator.compare(heapArray[right], heapArray[left]) > 0) {
                larger = right;
            } else {
                larger = left;
            }
            if (comparator.compare(top, heapArray[larger]) > 0) {
                break;
            }
            heapArray[i] = heapArray[larger];
            i = larger;
        }
        heapArray[i] = top;
    }
    

    private void trickleUp(int index) {
        HpNode bottom = heapArray[index];
        int parent = getParent(index);
        while (index > 0 && comparator.compare(heapArray[parent], bottom) < 0) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = getParent(parent);
        }
        heapArray[index] = bottom;
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

    
    private final int getParent(int index) {
        return (index - 1) / 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
