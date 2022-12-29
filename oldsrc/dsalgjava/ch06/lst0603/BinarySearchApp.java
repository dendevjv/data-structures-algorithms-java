package dsalgjava.ch06.lst0603;

import java.util.Scanner;

public class BinarySearchApp {

    public static void main(String[] args) {
        OrdArray arr = new OrdArray(100);
        
        arr.insert(72);
        arr.insert(90);
        arr.insert(45);
        arr.insert(126);
        arr.insert(54);
        arr.insert(99);
        arr.insert(144);
        arr.insert(27);
        arr.insert(135);
        arr.insert(81);
        arr.insert(18);
        arr.insert(108);
        arr.insert(9);
        arr.insert(117);
        arr.insert(63);
        arr.insert(36);
        arr.displayIndexed();
        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter search key: ");
        int key = in.nextInt();
        in.close();
        if (arr.find(key) != arr.size()) {
            System.out.println("Found " + key);
        } else {
            System.out.println("Can't find " + key);
        }
    }

}
