package dsalgjava.ch06.lst0605;

public class MergeApp {

    public static void main(String[] args) {
        int[] arrA = {23, 47, 81, 95};
        int[] arrB = {7, 14, 39, 55, 62, 74};
        int[] arrC = new int[arrA.length + arrB.length];
        
        merge(arrA, arrA.length, arrB, arrB.length, arrC);
        display(arrC, arrC.length);
    }

    private static void display(int[] a, int size) {
        for (int j = 0; j < size; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }

    private static void merge(int[] a, int sizeA, int[] b, int sizeB,
            int[] c) {
        int aIdx = 0;
        int bIdx = 0;
        int cIdx = 0;
        
        while (aIdx < sizeA && bIdx < sizeB) {
            if (a[aIdx] < b[bIdx]) {
                c[cIdx++] = a[aIdx++];
            } else {
                c[cIdx++] = b[bIdx++];
            }
        }
        while (aIdx < sizeA) {
            c[cIdx++] = a[aIdx++];
        }
        while (bIdx < sizeB) {
            c[cIdx++] = b[bIdx++];
        }
    }


}
