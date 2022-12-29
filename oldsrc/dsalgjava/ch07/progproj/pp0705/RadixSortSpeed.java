package dsalgjava.ch07.progproj.pp0705;

import java.util.Scanner;

//import dsalgjava.ch03.lst0303.ArrayIns;
import dsalgjava.ch07.lst0703.ArrayQ;
import dsalgjava.ch07.lst0705.ArrayQ3;
import dsalgjava.tools.CheckArray;
import dsalgjava.tools.RandomArray;

public class RadixSortSpeed {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter maxSize: ");
        int maxSize = in.nextInt();
        in.close();
        
        long start, finish;
        long[] values = RandomArray.createLong(maxSize, 0, maxSize);
        
//        ArrayIns arrIns = new ArrayIns(values);
//        start = System.currentTimeMillis();
//        arrIns.insertionSort();
//        finish = System.currentTimeMillis();
//        elapsed("Insertion : ", start, finish);
        
        ArrayQ arr1 = new ArrayQ(values);
        start = System.currentTimeMillis();
        arr1.quickSort();
        finish = System.currentTimeMillis();
        elapsed("Quicksort1: ", start, finish);
        
        ArrayQ3 arr3 = new ArrayQ3(values, 10);
        start = System.currentTimeMillis();
        arr3.quickSort();
        finish = System.currentTimeMillis();
        elapsed("Quicksort3: ", start, finish);
        
        ArrayRadix arrRadix = new ArrayRadix(values);
        start = System.currentTimeMillis();
        arrRadix.radixSort();
        finish = System.currentTimeMillis();
        elapsed("Radix sort: ", start, finish);
        
        System.out.println("\nCheck:");
        System.out.println("Non decreasing: " + CheckArray.isNonDecreasing(arrRadix.cloneInnerArray()));
    }

    private static void elapsed(String s, long start, long finish) {
        System.out.println(s + (finish - start) + " ms");
    }
}
