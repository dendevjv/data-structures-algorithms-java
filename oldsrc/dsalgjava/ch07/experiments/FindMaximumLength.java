package dsalgjava.ch07.experiments;

import java.util.Arrays;

public class FindMaximumLength {

    public static void main(String[] args) {
        int[] values = {0, 1, 9, 10, 11, 99, 100, 101, 111, 256, 999, 1000, 1001};
        int[] lengths = new int[values.length];
        for (int i = 0; i < lengths.length; i++) {
            lengths[i] = itemLength(values[i]);
        }
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(lengths));
    }

    private static int itemLength(long v) {
        if (v == 0) {
            return 1;
        }
        if (v < 0) {
            return itemLength(-v);
        }
        int len = 0;
        while (v != 0) {
            v /= 10;
            len++;
        }
        return len;
    }
}
