package dsalgjava.ch07.lst0704;

import dsalgjava.tools.CheckArray;
import dsalgjava.tools.RandomUtil;

public class QuickSortApp {

    public static void main(String[] args) {
        ArrayQ2 arr = new ArrayQ2(16);

        RandomUtil.fill(arr, 100);
        arr.display();

        arr.quickSort();
        arr.display();

        long[] inner = arr.cloneInnerArray();
        System.out.println("Non decreasing: "
                + CheckArray.isNonDecreasing(inner));
    }

}
