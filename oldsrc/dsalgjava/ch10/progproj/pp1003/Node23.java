package dsalgjava.ch10.progproj.pp1003;

import dsalgjava.ch10.lst1001.DataItem;

public class Node23 {
    private static final int ORDER = 3;
    public static final int MAX_NUM_ITEMS = ORDER - 1;
    
    private int numItems;
    private Node23 parent;
    private Node23[] childArray = new Node23[ORDER];
    private DataItem[] itemArray = new DataItem[MAX_NUM_ITEMS];
    
    public void connectChild(int childNum, Node23 child) {
        childArray[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }
    
    public Node23 disconnectChild(int childIndex) {
        Node23 tempNode = childArray[childIndex];
        childArray[childIndex] = null;
        return tempNode;
    }
    
    public void addChild(Node23 child) {
        long childKey = child.getItem(0).dData;
        int j = numItems;
        while (j > 0 && childArray[j - 1].getItem(0).dData > childKey) {
            childArray[j] = childArray[j - 1];
            j--;
        }
        childArray[j] = child;
    }
    
    public boolean isEmpty() {
        if (numItems > 0) {
            return false;
        }
        for (int i = 0; i < childArray.length; i++) {
            if (childArray[i] != null) {
                return false;
            }
        }
        return true;
    }
    
    public Node23 getChild(int childIndex) {
        return childArray[childIndex];
    }
    
    public Node23 getParent() {
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
        return numItems == MAX_NUM_ITEMS;
    }
    
    /**
     * Finds item with specified key value.
     * @param key
     * @return index of found item or -1
     */
    public int findItem(long key) {
        for (int j = 0; j < itemArray.length; j++) {
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
        
        for (int j = itemArray.length - 1; j >= 0; j--) {
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
     * Displays node in format "/24/56/".
     */
    public void display() {
        for (int j = 0; j < numItems; j++) {
            itemArray[j].display();
        }
        System.out.println("/");
    }
}
