package dsalgjava.ch11.progproj.pp1104;

import dsalgjava.ch11.lst1101.HashTableLinearProbing;
import dsalgjava.ch11.shared.DataItem;

public class HashTableRehashing extends HashTableLinearProbing {
    private static final double MAXIMUM_LOAD_FACTOR = 0.5;
    
    private int size;

    public HashTableRehashing(int size) {
        super(size);
    }

    @Override
    public void insert(DataItem item) {
        super.insert(item);
        size++;
        if (getLoadFactor() > MAXIMUM_LOAD_FACTOR) {
            rehash();
        }
    }
    
    private void insertWithoutRehash(DataItem item) {
        super.insert(item);
        size++;
    }
    
    private void rehash() {
        int newArraySize = getArraySize() * 2;
        newArraySize = nextPrime(newArraySize);
        HashTableRehashing newTable = new HashTableRehashing(newArraySize);
        for (int j = 0; j < this.hashArray.length; j++) {
            if (hashArray[j] != null && hashArray[j] != nonItem) {
                newTable.insertWithoutRehash(hashArray[j]);
            }
        }
        hashArray = newTable.hashArray;
        arraySize = newTable.arraySize;
    }

    private int nextPrime(int n) {
        while (true) {
            n++;
            if (isPrime(n)) {
                return n;
            }
        }
    }

    private boolean isPrime(int n) {
        for (int j = 2; j * j <= n; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }

    private double getLoadFactor() {
        return (double) size / getArraySize();
    }
}
