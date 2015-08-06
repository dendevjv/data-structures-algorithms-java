package dsalgjava.ch11.shared;

import java.util.Scanner;

public class HashTableBaseApp {
    private static Scanner in = new Scanner(System.in);
    private HashTableBase hashTable;
    
    public HashTableBaseApp(HashTableBase hashTable) {
        this.hashTable = hashTable;
    }
    
    public void doApp() {
        DataItem item;
        int aKey, size, n, keysPerCell;

        n = getInt("Enter initial number of items: ");
        keysPerCell = 10;

        size = hashTable.arraySize;
        for (int j = 0; j < n; j++) {
            aKey = (int) (Math.random() * keysPerCell * size);
            hashTable.insert(aKey);
        }

        outer: while (true) {
            char choice = getChar("Enter first letter of show, insert, delete, or find: ");
            switch (choice) {
            case 's':
                hashTable.display();
                break;
            case 'i':
                aKey = getInt("Enter key value to insert: ");
                hashTable.insert(aKey);
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
    
    public static char getChar(String prompt) {
        System.out.print(prompt);
        String s = in.nextLine();
        if (s.length() > 0) {
            return s.charAt(0);
        } else {
            return 0;
        }
    }

    public static int getInt(String prompt) {
        System.out.print(prompt);
        int n = in.nextInt();
        in.nextLine();
        return n;
    }
}
