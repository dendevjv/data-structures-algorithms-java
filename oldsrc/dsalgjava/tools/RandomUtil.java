package dsalgjava.tools;

import java.util.Random;

import dsalgjava.ch03.shared.ArrayBase;
import dsalgjava.ch07.lst0701.ArraySh;

public class RandomUtil {
    public static void fill(ArrayBase arr, int highLimit) {
        Random rnd = new Random();
        long n;
        for (int i = 0; i < arr.getCapacity(); i++) {
            n = rnd.nextInt(highLimit);
            arr.insert(n);
        }
    }

    public static void main(String[] args) {
        ArraySh arr = new ArraySh(10);
        fill(arr, 100);
        arr.display();
        arr.shellSort();
        arr.display();
    }

}
