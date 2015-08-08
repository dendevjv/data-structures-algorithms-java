package dsalgjava.ch11.progproj.pp1101;

import dsalgjava.ch11.shared.HashTableBase;
import dsalgjava.ch11.shared.HashTableBaseApp;
import dsalgjava.tools.Input;

public class HashTableQuadraticApp {

    public static void main(String[] args) {
        int size = Input.getInt("Enter size of hash table: ");
        HashTableBase hashTable = new HashTableQuadratic(size);
        HashTableBaseApp app = new HashTableBaseApp(hashTable); 
        app.doApp();
    }

}
