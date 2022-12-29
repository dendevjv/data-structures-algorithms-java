package dsalgjava.ch12.lst1202;

import dsalgjava.ch12.shared.HpNode;
import dsalgjava.tools.Input;

public class HeapSortingApp {

    public static void main(String[] args) {
        int size, j;
        size = Input.getInt("Enter number of items: ");
        HeapSorting heap = new HeapSorting(size);
        
        for (j = 0; j < size; j++) {
            int random = (int) (Math.random() * 100);
            HpNode node = new HpNode(random);
            heap.insertAt(j, node);
            heap.incrementSize();
        }
        
        System.out.println("Random:");
        heap.displayArray();
        
        for (j = size / 2; j >= 0; j--) {
            heap.trickleDown(j);
        }
        
        System.out.println("\nHeap:");
        heap.display();
        
        HpNode biggest;
        for (j = size - 1; j > 0; j--) {
            biggest = heap.remove();
            heap.insertAt(j, biggest);
        }
        System.out.println("\nSorted:");
        heap.displayArray();
    }

}
