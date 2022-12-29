package dsalgjava.ch03.lst0301;

import dsalgjava.tools.CheckArray;
import dsalgjava.tools.RandomArray;
import dsalgjava.tools.StopWatch;

public class ArrayBubPerf {

    private static final int SIZE = 40000;

    public static void main(String[] args) {
        long[] longArray = RandomArray.createLong(SIZE, 0, SIZE);
        StopWatch sw = new StopWatch();
        long elapsed;
        
        ArrayBub arr = new ArrayBub(longArray);
        System.out.println("ArrayBub:");
        sw.start();
        arr.bubbleSort();
        elapsed = sw.stop();
        System.out.println("elapsed " + elapsed);

        System.out.println("ArrayBubSwapInline:");
        ArrayBubSwapInline arr2 = new ArrayBubSwapInline(longArray);
        sw.start();
        arr2.bubbleSort();
        elapsed = sw.stop();
        System.out.println("elapsed " + elapsed);
    }
    
    /*
Size    Time
---------------------
10000   elapsed 390
20000   elapsed 1568
40000   elapsed 6297
100000  elapsed 39345
     */

    @SuppressWarnings("unused")
    private static void displayNonDecreasing(ArrayBub arr) {
        System.out.println("NonDecreasing: "
                + CheckArray.isNonDecreasing(arr.cloneInnerArray()));
    }

}
