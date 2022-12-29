package dsalgjava.ch07.lst0703;

import dsalgjava.tools.RandomUtil;

public class QuickSortApp {

    public static void main(String[] args) {
        ArrayQ arr = new ArrayQ(16);
        
        RandomUtil.fill(arr, 100);
        arr.display();
        
        arr.quickSort();
        arr.display();
    }

}
