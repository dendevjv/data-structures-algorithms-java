package dsalgjava.ch10.lst1001;

import java.util.Scanner;

public class Tree234App {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        long value;
        Tree234 tree = new Tree234();

        tree.insert(50);
//        tree.insert(40);
//        tree.insert(60);
//        tree.insert(30);
//        tree.insert(70);

        outer:
        while (true) {
            System.out.print("Enter first letter of show, insert, or find: ");
            char choice = getChar();
            switch (choice) {
            case 's':
                tree.display();
                break;
            case 'i':
                System.out.print("Enter value to insert: ");
                value = getInt();
                tree.insert(value);
                break;
            case 'f':
                System.out.print("Enter value to find: ");
                value = getInt();
                int found = tree.find(value);
                if (found != -1) {
                    System.out.println("Found " + value);
                } else {
                    System.out.println("Could not find " + value);
                }
                break;
            case 'x':
            case 'q':
                break outer;
            default:
                System.out.println("Invalid entry.");
                break;
            }
        }
        in.close();
    }

    private static long getInt() {
        int n = in.nextInt();
        in.nextLine();
        return n;
    }

    private static char getChar() {
        String s = in.nextLine();
        return s.charAt(0);
    }

}
