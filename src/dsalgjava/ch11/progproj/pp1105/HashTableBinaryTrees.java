package dsalgjava.ch11.progproj.pp1105;

/**
 * Demonstrates hash table with binary search trees.
 */
public class HashTableBinaryTrees {
    private HtBinaryTree[] hashArray;
    private int arraySize;
    
    public HashTableBinaryTrees(int size) {
        arraySize = size;
        hashArray = new HtBinaryTree[arraySize];
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = new HtBinaryTree();
        }
    }
    
    public void display() {
        for (int j = 0; j < arraySize; j++) {
            System.out.print(j + ". ");
            hashArray[j].display();
            System.out.println();
        }
    }
    
    private int hashFunc(int key) {
        return key % arraySize;
    }
    
    public void insert(int key) {
        int hashVal = hashFunc(key);
        try {
            hashArray[hashVal].add(key);
        } catch (HtBinaryTreeDuplicateKeyException e) {
            System.out.println("Duplicate keys not allowed");
        }
    }
    
    public HtbtNode find(int key) {
        int hashVal = hashFunc(key);
        HtbtNode node = hashArray[hashVal].find(key);
        return node;
    }
}
