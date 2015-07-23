package dsalgjava.ch08.lst0801;

import java.util.Scanner;

public class TreeApp {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int value;
        Tree tree = new Tree(new int[] {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15});

        outer:
        while (true) {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, traverse or quit: ");
            char choice = in.nextLine().charAt(0);
            switch (choice) {
            case 's':
                tree.displayTree();
                break;
            case 'i':
                value = getInt("Enter value to insert: ");
                tree.insert(value, value + 0.9);
                break;
            case 'f':
                value = getInt("Enter value to find: ");
                Node found = tree.find(value);
                if (found != null) {
                    System.out.print("Found: ");
                    found.display();
                    System.out.println();
                } else {
                    System.out.println("Could not find " + value);
                }
                break;
            case 'd':
                value = getInt("Enter value to delete: ");
                boolean deleted = tree.delete(value);
                if (deleted) {
                    System.out.println("Deleted " + value);
                } else {
                    System.out.println("Could not delete " + value);
                }
                break;
            case 't':
                value = getInt("Enter type 1, 2 or 3: ");
                Tree.TraverseType type = Tree.TraverseType.values()[value - 1];
                tree.traverse(type);
                break;
            case 'q':
                break outer;
            default:
                System.out.println("Invalid entry");
                break;
            }
        }
        in.close();
    }

    private static int getInt(String prompt) {
        System.out.print(prompt);
        int n = in.nextInt();
        in.nextLine();
        return n;
    }

}
