package dsalgjava.ch03.progproj.pp0304;

import dsalgjava.tools.CheckArray;
import dsalgjava.tools.RandomArray;

public class ArrayOddEvenTesting {

    private static final int SIZE = 20;

    public static void main(String[] args) {
        ArrayOddEven arr = new ArrayOddEven(RandomArray.createLong(SIZE, 0, SIZE));
        arr.display();
        
        arr.oddEvenSort();
        arr.display();
        testNonDecreasing(arr);
    }

    private static void testNonDecreasing(ArrayOddEven arr) {
        long[] a = arr.cloneInnerArray();
        boolean ok = CheckArray.isNonDecreasing(a);
        System.out.println(ok ? "passed" : "failed");
    }

}
