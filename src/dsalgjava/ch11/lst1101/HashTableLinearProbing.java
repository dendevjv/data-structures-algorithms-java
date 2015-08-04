package dsalgjava.ch11.lst1101;

import dsalgjava.ch11.shared.DataItem;
import dsalgjava.ch11.shared.HashTableBase;

public class HashTableLinearProbing extends HashTableBase {
    
    public HashTableLinearProbing(int size) {
        super(size);
    }
    
    private int hashFunc(int key) {
        return key % arraySize;
    }
    
    public void insert(DataItem item) {
        int hashValue = hashFunc(item.getKey());
        while (hashArray[hashValue] != null && hashArray[hashValue] != nonItem) {
            hashValue++;
            hashValue %= arraySize;
        }
        hashArray[hashValue] = item;
    }
    
    public DataItem delete(int key) {
        int hashValue = hashFunc(key);
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                DataItem item = hashArray[hashValue];
                hashArray[hashValue] = nonItem;
                return item;
            }
            hashValue++;
            hashValue %= arraySize;
        }
        return null;
    }
    
    public DataItem find(int key) {
        int hashValue = hashFunc(key);
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                return hashArray[hashValue];
            }
            hashValue++;
            hashValue %= arraySize;
        }
        return null;
    }
}
