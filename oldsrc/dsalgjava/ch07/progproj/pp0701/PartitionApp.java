package dsalgjava.ch07.progproj.pp0701;

import dsalgjava.tools.RandomUtil;

public class PartitionApp {

    public static void main(String[] args) {
        int maxSize = 16;
        ArrayPar arr = new ArrayPar(maxSize);
        
        RandomUtil.fill(arr, maxSize);
        arr.display();

        int partDex = arr.partitionIt(0, arr.getSize() - 1);
        
        System.out.println("Partition is at index " + partDex);
        arr.displayIndexed();
    }

}
