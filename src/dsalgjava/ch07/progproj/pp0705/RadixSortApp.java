package dsalgjava.ch07.progproj.pp0705;

import java.util.Scanner;

import dsalgjava.tools.CheckArray;
import dsalgjava.tools.RandomUtil;

public class RadixSortApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size = in.nextInt();
        in.close();
        ArrayRadix arr = new ArrayRadix(size);
        
        RandomUtil.fill(arr, size);
        arr.display();

        arr.radixSort();
        arr.display();
        System.out.println("Non decreasing: " + CheckArray.isNonDecreasing(arr.cloneInnerArray()));
    }

}
