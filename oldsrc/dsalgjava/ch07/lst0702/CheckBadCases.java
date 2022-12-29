package dsalgjava.ch07.lst0702;

import java.util.Scanner;

import dsalgjava.tools.ArrayTools;

public class CheckBadCases {

    public static void main(String[] args) {
        String[] ss = { " 10  5 11  4 15 12  1 14 15 11  1  5  6 10 11 10",
                "1  2 12  6  1  4 14  4  0  5 13  2  6 15  2  6", /* produces incorrect result */
                "0  0  4  4  0 13 10 13  9  4  5 15 13  2 13 14" /* produces incorrect result */ };
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < ss.length; i++) {
            System.out.println("Test #" + (i+1));
            ArrayPar arr = new ArrayPar(ArrayTools.stringToLongArray(ss[i]));
            arr.displayIndexed();
            System.out.print("Enter pivot: ");
            long pivot = in.nextLong();
            int partition = arr.partitionIt2(0, arr.getSize() - 1, pivot);

            System.out.println("Partition is at index " + partition);
            arr.displayIndexed();
        }
        in.close();
    }

}
