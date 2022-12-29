package dsalgjava.ch11.progproj.pp1103;

import dsalgjava.ch11.shared.HashTableBase;
import dsalgjava.ch11.shared.HashTableBaseApp;
import dsalgjava.tools.Input;

public class HashTableFoldingApp {

    public static void main(String[] args) {
        int size = Input.getInt("Enter size of hash table: ");
        HashTableBase hashTable = new HashTableFolding(size);
        HashTableBaseApp app = new HashTableBaseApp(hashTable); 
        app.doApp();
    }

}
