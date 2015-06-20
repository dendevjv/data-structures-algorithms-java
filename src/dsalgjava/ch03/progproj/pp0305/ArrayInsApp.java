package dsalgjava.ch03.progproj.pp0305;

import java.util.Arrays;

import dsalgjava.tools.CheckArray;
import dsalgjava.tools.RandomArray;

public class ArrayInsApp {

    private static final double PERCENT_SORTED = 0.99;

    public static void main(String[] args) {
        testAlmostSorted(100);
        testAlmostSorted(200);
        testAlmostSorted(400);
        testAlmostSorted(800);
    }

    @SuppressWarnings("unused")
    private static void testRandom(int size) {
        ArrayIns arr = new ArrayIns(RandomArray.createLong(size, 0, size));
        test(arr);
    }
    
    private static void testAlmostSorted(int size) {
        long[] tmp = RandomArray.createLong(size, 0, size);
        int fromIndex = (int) (size * (1.0 - PERCENT_SORTED));
        int toIndex = (int) (size * PERCENT_SORTED);
        Arrays.sort(tmp, fromIndex, toIndex);
        ArrayIns arr = new ArrayIns(tmp);
        test(arr);
    }

    private static void test(ArrayIns arr) {
        System.out.println("NonDecreasing: "
                + CheckArray.isNonDecreasing(arr.cloneInnerArray()));
        arr.insertionSort();
        System.out.println("NonDecreasing: "
                + CheckArray.isNonDecreasing(arr.cloneInnerArray()));
        System.out.println();
    }

}
