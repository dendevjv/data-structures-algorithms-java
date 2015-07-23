package dsalgjava.ch08.lst0801;

import java.util.Scanner;

public class TreeApp {

    public static void main(String[] args) {
        int value;
        
        Tree tree = new Tree(new int[] {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15});

        Scanner in = new Scanner(System.in);
        outer:
        while (true) {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, traverse or quit: ");
            char choice = in.nextLine().charAt(0);
            switch (choice) {
            case 's':
                tree.displayTree();
                break;
            case 'q':
                break outer;
            }
        }
        in.close();
    }

}
