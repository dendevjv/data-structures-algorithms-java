package dsalgjava.ch11.progproj.pp1104;

import dsalgjava.ch11.shared.HashTableBase;
import dsalgjava.ch11.shared.HashTableBaseApp;
import dsalgjava.tools.Input;

public class HashTableRehashingApp {
    public static void main(String[] args) {
        int size = Input.getInt("Enter size of hash table: ");
        HashTableBase hashTable = new HashTableRehashing(size);
        HashTableBaseApp app = new HashTableBaseApp(hashTable); 
        app.doApp();
    }
}
