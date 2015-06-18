package dsalgjava.ch03.progproj.pp0301;

import dsalgjava.ch03.shared.ArrayNonSorted;

/**
 * Bidirectional bubble sort.
 */
public class ArrayBubBiDir extends ArrayNonSorted {

    public ArrayBubBiDir(int max) {
        super(max);
    }

    public ArrayBubBiDir(long[] array) {
        super(array);
    }

    public void bubbleSort() {
        int next, prev;
        int right = nElems - 1;
        int left = 0;
        while (right > left) {
            for (int i = left; i < right; i++) {
                next = i + 1;
                if (a[i] > a[next]) {
                    swap(i, next);
                }
            }
            right--;
            for (int j = right; j > left; j--) {
                prev = j - 1;
                if (a[prev] > a[j]) {
                    swap(j, prev);
                }
            }
            left++;
        }
    }

}
