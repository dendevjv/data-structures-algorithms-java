package dsalgjava.ch06.research.sortingspeed;

import java.util.Random;
import java.util.Scanner;

import dsalgjava.ch03.lst0301.ArrayBub;
import dsalgjava.ch03.lst0302.ArraySel;
import dsalgjava.ch03.lst0303.ArrayIns;
import dsalgjava.ch06.lst0606.DArray;

public class Sorting {
    private static Random rnd = new Random();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter range: ");
        int maxSize = in.nextInt();
        in.close();
        long start, finish;
        
        DArray a1 = new DArray(maxSize );
        for (int i = 0; i < maxSize; i++) {
            a1.insert(rnd.nextLong());
        }
        start = System.currentTimeMillis();
        a1.mergeSort();
        finish = System.currentTimeMillis();
        System.out.println("Merge sort    : " + (finish - start) + " ms");
        
        ArrayBub a2 = new ArrayBub(maxSize);
        for (int i = 0; i < maxSize; i++) {
            a2.insert(rnd.nextLong());
        }
        start = System.currentTimeMillis();
        a2.bubbleSort();
        finish = System.currentTimeMillis();
        System.out.println("Bubble sort   : " + (finish - start) + " ms");
        
        ArraySel a3 = new ArraySel(maxSize);
        for (int i = 0; i < maxSize; i++) {
            a3.insert(rnd.nextLong());
        }
        start = System.currentTimeMillis();
        a3.selectionSort();
        finish = System.currentTimeMillis();
        System.out.println("Selection sort: " + (finish - start) + " ms");
        
        ArrayIns a4 = new ArrayIns(maxSize);
        for (int i = 0; i < maxSize; i++) {
            a4.insert(rnd.nextLong());
        }
        start = System.currentTimeMillis();
        a4.insertionSort();
        finish = System.currentTimeMillis();
        System.out.println("Insertion sort: " + (finish - start) + " ms");
    }

}
