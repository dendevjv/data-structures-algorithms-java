package dsalgjava.ch11.progproj.pp1105;

import java.util.Scanner;

import dsalgjava.tools.Input;

public class HashTableBinaryTreesApp {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        HtbtNode node;
        int aKey, size, n, keysPerCell;
        
        size = Input.getInt("Enter size of hash table: ");
        
        HashTableBinaryTrees hashTable = new HashTableBinaryTrees(size);

        n = Input.getInt("Enter initial number of items: ");
        keysPerCell = 10;

        for (int j = 0; j < n; j++) {
            aKey = (int) (Math.random() * keysPerCell * size);
            hashTable.insert(aKey);
        }

        outer: while (true) {
            char choice = Input.getChar("Enter first letter of show, insert, or find: ");
            switch (choice) {
            case 's':
                hashTable.display();
                break;
            case 'i':
                aKey = Input.getInt("Enter key value to insert: ");
                hashTable.insert(aKey);
                break;
            case 'f':
                aKey = Input.getInt("Enter key value to find: ");
                node = hashTable.find(aKey);
                if (node != null) {
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

}
