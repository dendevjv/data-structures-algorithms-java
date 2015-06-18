package dsalgjava.tools;

import java.util.Arrays;
import java.util.Random;

public class RandomArray {
    private static Random random = new Random();
    
    /**
     * Creates array of random elements.
     * @param size size of the array
     * @param from minimum value inclusive
     * @param to maximum value exclusive
     * @return
     */
    public static long[] createLong(int size, long from, long to) {
        long[] arr = new long[size];
        long diff = to - from;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = from + (long)(diff * random.nextDouble());
        }
        return arr;
    }

    public static void main(String[] args) {
        long a[] = createLong(20, 1, 4);
        System.out.println(Arrays.toString(a));
    }

}
