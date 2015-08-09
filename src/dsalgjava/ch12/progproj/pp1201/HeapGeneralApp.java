package dsalgjava.ch12.progproj.pp1201;

import java.util.Comparator;

import dsalgjava.ch12.shared.HpNode;
import dsalgjava.tools.Input;

public class HeapGeneralApp {

    public static void main(String[] args) {
        Comparator<HpNode> comparator = new Comparator<HpNode>() {
            @Override
            public int compare(HpNode o1, HpNode o2) {
                return o2.getKey() - o1.getKey();
            }
        };
        HeapGeneral heap = new HeapGeneral(31, comparator);
        
        heap.insert(70);
        heap.insert(40);
        heap.insert(50);
        heap.insert(20);
        heap.insert(60);
        heap.insert(100);
        heap.insert(80);
        heap.insert(30);
        heap.insert(10);
        heap.insert(90);
        heap.display();
        
        int value, value2;
        boolean success;
        outer: while (true) {
            char choice = Input.getChar("Enter first letter of show, insert, remove, change: ");
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
