package dsalgjava.ch07.progproj.pp0702;

import java.util.Scanner;

import dsalgjava.tools.CheckArray;
import dsalgjava.tools.RandomUtil;

public class QuickSortCountingApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size = in.nextInt();
        in.close();
        System.out.println("N*log(N)=" + (size * Math.log10(size) / Math.log10(2)));
        ArrayQ2Counter arr = new ArrayQ2Counter(size);

        RandomUtil.fill(arr, 100);
//        arr.display();

        arr.quickSort();
//        arr.display();
        System.out.println("Total copies     : " + arr.getCopies());
        System.out.println("Total comparisons: " + arr.getComparisons());

        long[] inner = arr.cloneInnerArray();
        System.out.println("Non decreasing: "
                + CheckArray.isNonDecreasing(inner));
    }

}
