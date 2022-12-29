package dsalgjava.ch11.progproj.pp1101;

import dsalgjava.ch11.shared.DataItem;
import dsalgjava.ch11.shared.HashTableBase;

public class HashTableQuadratic extends HashTableBase {
    private Stepper stepper = new Stepper();
    
    public HashTableQuadratic(int size) {
        super(size);
    }
    
    private int hashFunc(int key) {
        return key % arraySize;
    }
    
    public void insert(DataItem item) {
        int hashValue = hashFunc(item.getKey());
        stepper.init();
        while (hashArray[hashValue] != null && hashArray[hashValue] != nonItem) {
            hashValue += stepper.next();
            hashValue %= arraySize;
        }
        hashArray[hashValue] = item;
    }
    
    public DataItem delete(int key) {
        int hashValue = hashFunc(key);
        stepper.init();
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                DataItem item = hashArray[hashValue];
                hashArray[hashValue] = nonItem;
                return item;
            }
            hashValue += stepper.next();
            hashValue %= arraySize;
        }
        return null;
    }
    
    public DataItem find(int key) {
        int hashValue = hashFunc(key);
        stepper.init();
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                return hashArray[hashValue];
            }
            hashValue += stepper.next();
            hashValue %= arraySize;
        }
        return null;
    }
    
    private static class Stepper {
        private int count = 0;
        
        void init() {
            count = 0;
        }
        
        int next() {
            count++;
            return count * count;
        }
    }
}
