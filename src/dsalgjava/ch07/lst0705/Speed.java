package dsalgjava.ch07.lst0705;

import java.util.Scanner;

import dsalgjava.ch03.lst0303.ArrayIns;
import dsalgjava.ch07.lst0703.ArrayQ;
import dsalgjava.tools.RandomArray;

public class Speed {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter maxSize: ");
        int maxSize = in.nextInt();
        System.out.print("Enter cutOff: ");
        int cutOff = in.nextInt();
        in.close();
        
        long start;
        long[] values = RandomArray.createLong(maxSize, 0, maxSize);
        
        ArrayIns arrIns = new ArrayIns(values);
        start = System.currentTimeMillis();
        arrIns.insertionSort();
        elapsed("Insertion : ", start);
        
        ArrayQ arr1 = new ArrayQ(values);
        start = System.currentTimeMillis();
        arr1.quickSort();
        elapsed("Quicksort1: ", start);
        
        ArrayQ3 arr3 = new ArrayQ3(values, cutOff);
        start = System.currentTimeMillis();
        arr3.quickSort();
        elapsed("Quicksort3: ", start);
    }
    
    private static void elapsed(String s, long start) {
        System.out.println(s + (System.currentTimeMillis() - start) + " ms");
    }

}
