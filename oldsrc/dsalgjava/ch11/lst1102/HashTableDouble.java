package dsalgjava.ch11.lst1102;

import dsalgjava.ch11.shared.DataItem;
import dsalgjava.ch11.shared.HashTableBase;

/**
 * Demonstrates hash table with double hashing
 */
public class HashTableDouble extends HashTableBase {

    public HashTableDouble(int size) {
        super(size);
    }
    
    private int hashFunc1(int key) {
        return key % arraySize;
    }
    
    private int hashFunc2(int key) {
        // non-zero, less than array size, different from hF1
        // array size must be relatively prime to 5, 4, 3, and 2
        return 5 - key % 5;
    }

    @Override
    public void insert(DataItem item) {
        int hashVal = hashFunc1(item.getKey());
        int stepSize = hashFunc2(item.getKey());
        while (hashArray[hashVal] != null && hashArray[hashVal] != nonItem) {
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    @Override
    public DataItem delete(int key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem item = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return item;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    @Override
    public DataItem find(int key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }
}
