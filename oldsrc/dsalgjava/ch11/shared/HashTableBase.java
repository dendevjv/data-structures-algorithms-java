package dsalgjava.ch11.shared;

public abstract class HashTableBase {
    protected DataItem[] hashArray;
    protected int arraySize;
    protected DataItem nonItem; // for deleted items
    
    public HashTableBase(int size) {
        arraySize = size;
        hashArray = new DataItem[size];
        nonItem = new DataItem(-1);
    }
    
    public int getArraySize() {
        return arraySize;
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
    
    public abstract void insert(DataItem item);
    
    public void insert(int value) {
        insert(new DataItem(value));
    }
    
    public abstract DataItem delete(int key);
    
    public abstract DataItem find(int key);
}
