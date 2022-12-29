package dsalgjava.ch03.progproj.pp0301;

import dsalgjava.tools.CheckArray;
import dsalgjava.tools.RandomArray;

public class ArrayBubBiDirTesting {

    private static final int SIZE = 11;

    public static void main(String[] args) {
        test();
        test();
        test();
        test();
        test();
    }

    private static void test() {
        ArrayBubBiDir arr = createRandom(SIZE);
        arr.display();
        boolean before = CheckArray.isNonDecreasing(arr.cloneInnerArray());
        arr.bubbleSort();
        arr.display();
        boolean after = CheckArray.isNonDecreasing(arr.cloneInnerArray());
        System.out.println((!before && after) ? "passed" : "failed");
    }

    private static ArrayBubBiDir createRandom(int size) {
        long[] a = RandomArray.createLong(size, 0, size);
        ArrayBubBiDir arr = new ArrayBubBiDir(a);
        return arr;
    }
}
