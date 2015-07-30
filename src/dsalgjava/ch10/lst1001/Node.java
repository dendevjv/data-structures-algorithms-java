package dsalgjava.ch10.lst1001;

public class Node {
    private static final int ORDER = 4;
    
    private int numItems;
    private Node parent;
    private Node[] childArray = new Node[ORDER];
    private DataItem[] itemArray = new DataItem[ORDER - 1];
    
    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }
    
    public Node disconnectChild(int childIndex) {
        Node tempNode = childArray[childIndex];
        childArray[childIndex] = null;
        return tempNode;
    }
    
    public Node getChild(int childIndex) {
        return childArray[childIndex];
    }
    
    public Node getParent() {
        return parent;
    }
    
    public boolean isLeaf() {
        return childArray[0] == null;
    }
    
    public int getNumItems() {
        return numItems;
    }
    
    public DataItem getItem(int index) {
        return itemArray[index];
    }
    
    public boolean isFull() {
        return numItems == ORDER - 1;
    }
    
    /**
     * Finds item with specified key value.
     * @param key
     * @return index of found item or -1
     */
    public int findItem(long key) {
        for (int j = 0; j < ORDER - 1; j++) {
            if (itemArray[j] == null) {
                break;
            } else if (itemArray[j].dData == key) {
                return j;
            }
        }
        return -1;
    }
    
    /**
     * Inserts new item. Assumes node is not full.
     * @param newItem
     * @return index to new item
     */
    public int insertItem(DataItem newItem) {
        numItems++;
        long newKey = newItem.dData;
        
        for (int j = ORDER - 2; j >= 0; j--) {
            if (itemArray[j] == null) {
                continue;
            } else {
                long itsKey = itemArray[j].dData;
                if (newKey < itsKey) {
                    itemArray[j + 1] = itemArray[j];
                } else {
                    itemArray[j + 1] = newItem;
                    return j + 1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }
    
    /**
     * Removes largest item. Assumes node not empty.
     * @return removed item
     */
    public DataItem removeItem() {
        DataItem temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = null;
        numItems--;
        return temp;
    }
    
    /**
     * Displays node in format "/24/56/74/".
     */
    public void display() {
        for (int j = 0; j < numItems; j++) {
            itemArray[j].display();
        }
        System.out.println("/");
    }
}
