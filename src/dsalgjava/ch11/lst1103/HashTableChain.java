package dsalgjava.ch11.lst1103;

/**
 * Demonstrates hash table with separate chaining.
 */
public class HashTableChain {
    private SortedList[] hashArray;
    private int arraySize;
    
    public HashTableChain(int size) {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = new SortedList();
        }
    }
    
    public void display() {
        for (int j = 0; j < arraySize; j++) {
            System.out.print(j + ". ");
            hashArray[j].display();
        }
    }
    
    private int hashFunc(int key) {
        return key % arraySize;
    }
    
    public void insert(Link link) {
        int key = link.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(link);
    }
    
    public void insert(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(key);
    }
    
    public void delete(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }
    
    public Link find(int key) {
        int hashVal = hashFunc(key);
        Link link = hashArray[hashVal].find(key);
        return link;
    }
}
