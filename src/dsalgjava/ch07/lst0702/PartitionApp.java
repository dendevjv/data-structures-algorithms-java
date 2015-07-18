package dsalgjava.ch07.lst0702;

import dsalgjava.tools.RandomUtil;

public class PartitionApp {

    public static void main(String[] args) {
        int maxSize = 16;
        ArrayPar arr = new ArrayPar(maxSize);
        
        RandomUtil.fill(arr, 200);
        arr.display();

        long pivot = 99;
        System.out.println("Pivot is " + pivot);
        int partDex = arr.partitionIt2(0, arr.getSize() - 1, pivot);
        
        System.out.println("Partition is at index " + partDex);
        arr.displayIndexed();
    }

}
