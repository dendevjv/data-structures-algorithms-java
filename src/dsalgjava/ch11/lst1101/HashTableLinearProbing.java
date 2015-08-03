package dsalgjava.ch11.lst1101;

public class HashTableLinearProbing {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem; // for deleted items
    
    public HashTableLinearProbing(int size) {
        arraySize = size;
        hashArray = new DataItem[size];
        nonItem = new DataItem(-1);
    }
    
    public void display() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null) {
                System.out.print(hashArray[j].getKey() + " ");
            } else {
                System.out.print("** ");
            }
        }
        System.out.println();
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
    
    public void insert(int value) {
        insert(new DataItem(value));
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
