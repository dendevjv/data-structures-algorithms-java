package dsalgjava.ch11.progproj.pp1103;

import dsalgjava.ch11.lst1101.HashTableLinearProbing;

public class HashTableFolding extends HashTableLinearProbing {

    public HashTableFolding(int size) {
        super(size);
    }
    
    @Override
    protected int hashFunc(int key) {
        int hash = 0;
        int size = getArraySize();
        while (key != 0) {
            hash += key % size;
            key /= size;
        }
        hash %= size;
        return hash;
    }
    
}
