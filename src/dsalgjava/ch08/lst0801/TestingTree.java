package dsalgjava.ch08.lst0801;

import java.util.Scanner;

public class TestingTree {

    public static void main(String[] args) {
        int[] v = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        Tree t = new Tree();
        for (int n : v) {
            t.insert(n, n * 11);
        }
        t.display();
        
        t.traverse(1);
        t.traverse(2);
        t.traverse(3);
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter key: ");
//        int k = in.nextInt();
//        in.close();
//        Node n = t.find(k);
//        if (n != null) {
//            System.out.println("Found : " + n);
//        } else {
//            System.out.println("nothing found.");
//        }
    }

}
