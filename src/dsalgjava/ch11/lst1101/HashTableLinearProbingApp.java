package dsalgjava.ch11.lst1101;

import java.util.Scanner;

public class HashTableLinearProbingApp {
    private final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        DataItem item;
        int aKey, size, n, keysPerCell;

        size = getInt("Enter size of hash table: ");
        n = getInt("Enter initial number of items: ");
        keysPerCell = 10;

        HashTableLinearProbing hashTable = new HashTableLinearProbing(size);

        for (int j = 0; j < n; j++) {
            aKey = (int) (Math.random() * keysPerCell * size);
            item = new DataItem(aKey);
            hashTable.insert(item);
        }

        outer: while (true) {
            char choice = getChar("Enter first letter of show, insert, delete, or find: ");
            switch (choice) {
            case 's':
                hashTable.display();
                break;
            case 'i':
                aKey = getInt("Enter key value to insert: ");
                item = new DataItem(aKey);
                hashTable.insert(item);
                break;
            case 'd':
                aKey = getInt("Enter key value to delete: ");
                hashTable.delete(aKey);
                break;
            case 'f':
                aKey = getInt("Enter key value to find: ");
                item = hashTable.find(aKey);
                if (item != null) {
                    System.out.println("Found " + aKey);
                } else {
                    System.out.println("Could not find " + aKey);
                }
                break;
            case 'x':
            case 'q':
                break outer;
            default:
                System.out.println("Invalid entry.");
                break;
            } // end switch
        } // end while

        in.close();
    }

    private static char getChar(String prompt) {
        System.out.print(prompt);
        String s = in.nextLine();
        if (s.length() > 0) {
            return s.charAt(0);
        } else {
            return 0;
        }
    }

    private static int getInt(String prompt) {
        System.out.print(prompt);
        int n = in.nextInt();
        in.nextLine();
        return n;
    }

}
