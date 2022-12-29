package dsalgjava.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    
    /**
     * Creates array of random elements.
     * @param size size of the array
     * @param from minimum value inclusive
     * @param to maximum value exclusive
     * @return
     */
    public static int[] createInt(int size, int from, int to) {
        int[] arr = new int[size];
        int diff = to - from;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = from + (int)(diff * random.nextDouble());
        }
        return arr;
    }
    
    public static int[] createIntNonDuplicate(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int[] a = new int[list.size()];
        for (int i = 0; i < size; i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    public static void main(String[] args) {
        long a[] = createLong(20, 1, 4);
        System.out.println(Arrays.toString(a));
    }

}
