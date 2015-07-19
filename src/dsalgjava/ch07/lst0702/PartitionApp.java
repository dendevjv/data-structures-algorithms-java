package dsalgjava.ch07.lst0702;

import java.util.Scanner;

import dsalgjava.tools.RandomUtil;

public class PartitionApp {

    public static void main(String[] args) {
        int maxSize = 16;
        ArrayPar arr = new ArrayPar(maxSize);
        
        RandomUtil.fill(arr, 200);
        arr.display();

        Scanner in = new Scanner(System.in);
        System.out.print("Pivot: ");
        long pivot = in.nextLong();
        in.close();
        System.out.println("Pivot is " + pivot);
        int partDex = arr.partitionIt2(0, arr.getSize() - 1, pivot);
        
        System.out.println("Partition is at index " + partDex);
        arr.displayIndexed();
    }

}
