package dsalgjava.ch11.lst1102;

import dsalgjava.ch11.shared.HashTableBase;
import dsalgjava.ch11.shared.HashTableBaseApp;
import dsalgjava.tools.Input;

public class HashTableDoubleApp {

    public static void main(String[] args) {
        int size = Input.getInt("Enter size of hash table: ");
        HashTableBase hashTable = new HashTableDouble(size);
        HashTableBaseApp app = new HashTableBaseApp(hashTable);
        app.doApp();
    }

}
