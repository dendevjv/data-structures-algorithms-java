package dsalgjava.ch03.lst0301;

import dsalgjava.tools.CheckArray;

public class BubbleSortApp {

    public static void main(String[] args) {
        ArrayBub arr = new ArrayBub(100);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);

        arr.display();
        System.out.println("NonDecreasing: "
                + CheckArray.isNonDecreasing(arr.cloneInnerArray()));

        arr.bubbleSort();
        arr.display();
        System.out.println("NonDecreasing: "
                + CheckArray.isNonDecreasing(arr.cloneInnerArray()));
    }

}
