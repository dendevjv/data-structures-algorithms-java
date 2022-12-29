package dsalgjava.ch03.progproj.pp0306;

import dsalgjava.tools.CheckArray;
import dsalgjava.tools.RandomArray;

public class ArrayInsApp {

    private static final int SIZE = 20;

    public static void main(String[] args) {
        ArrayIns arr = new ArrayIns(RandomArray.createLong(SIZE, 0, 5));
        long[] initial = arr.cloneInnerArray();
        
        arr.display();
        System.out.println("NonDecreasing: "
                + CheckArray.isNonDecreasing(arr.cloneInnerArray()));
        
        arr.insertionSortNoDupes();
        long[] sorted = arr.cloneInnerArray();
        arr.display();
        System.out.println("NonDecreasing: "
                + CheckArray.isNonDecreasing(arr.cloneInnerArray()));
        System.out.println("Contain same set of elements: " + CheckArray.containSameSetOfElements(initial, sorted));
    }

}
