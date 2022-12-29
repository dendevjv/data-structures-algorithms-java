package dsalgjava.ch07.experiments;

import java.util.Arrays;

public class Partitioning {

    public static void main(String[] args) {
        int[] a = {8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        int p = partitionIt(a, 4);
        System.out.println("partition=" + p);
        System.out.println(Arrays.toString(a));
    }

    private static int partitionIt(int[] a, int pivot) {
        int i = -1;
        int j = a.length;
        while (i <= j) {
            while (i < a.length && a[++i] < pivot) {
                ; // nop
            }
            while (j > 0 && a[--j] > pivot) {
                ; // nop
            }
            if (i < j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        return i;
    }

}
