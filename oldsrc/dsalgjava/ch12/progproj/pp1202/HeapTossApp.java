package dsalgjava.ch12.progproj.pp1202;

import dsalgjava.tools.Input;

public class HeapTossApp {

    public static void main(String[] args) {
        HeapToss heap = new HeapToss(31);
        
        heap.toss(70);
        heap.toss(40);
        heap.toss(50);
        heap.toss(20);
        heap.toss(60);
        heap.toss(100);
        heap.toss(80);
        heap.toss(30);
        heap.toss(10);
        heap.toss(90);
        heap.restoreHeap();
        heap.display();
        
        int value, value2;
        boolean success;
        outer: while (true) {
            char choice = Input.getChar("Enter first letter of show, insert, toss, heap restore, remove, change: ");
            switch (choice) {
            case 's':
                heap.display();
                break;
            case 'i':
                value = Input.getInt("Enter value to insert: ");
                success = heap.insert(value);
                if (!success) {
                    System.out.println("Can't insert; heap full");
                }
                break;
            case 't':
                value = Input.getInt("Enter value to toss: ");
                success = heap.toss(value);
                if (!success) {
                    System.out.println("Can't toss; heap full");
                }
                break;
            case 'h':
                heap.restoreHeap();
                break;
            case 'r':
                if (!heap.isEmpty()) {
                    heap.remove();
                } else {
                    System.out.println("Can't remove; heap empty");
                }
                break;
            case 'c':
                value = Input.getInt("Enter current index of item: ");
                value2 = Input.getInt("Enter new key: ");
                success = heap.change(value, value2);
                if (!success) {
                    System.out.println("Invalid index");
                }
                break;
            case 'q':
            case 'x':
                break outer;
            } // end switch
        } // end while
    } // end main()

}
