package dsalgjava.ch10.progproj.pp1003;

import dsalgjava.ch10.lst1001.DataItem;

public class Tree23 {
    protected Node23 root = new Node23();

    public int find(long key) {
        Node23 curNode = root;
        int childNumber;
        while (true) {
            childNumber = curNode.findItem(key);
            if (childNumber != -1) {            // found it
                return childNumber;
            } else if (curNode.isLeaf()) {      // can't find it
                return -1;
            } else {                            // search deeper
                curNode = getNextChild(curNode, key);
            }
        }
    }
    
    public void insert(long dValue) {
        Node23 curNode = root;
        DataItem tempItem = new DataItem(dValue);
        
        while (!curNode.isLeaf()) {
            curNode = getNextChild(curNode, dValue);
        }
        insert(curNode, tempItem);
    }
    
    private void insert(Node23 node, DataItem item) {
        if (node.isFull()) {
            splitAndInsert(node, item);
        } else {
            node.insertItem(item);
        }
    }
    
    public void display() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node23 thisNode, int level, int childNumber) {
        System.out.print("level=" + level + " child=" + childNumber + " ");
        thisNode.display();
        
        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            Node23 nextNode = thisNode.getChild(j);
            if (nextNode != null) {
                recDisplayTree(nextNode, level + 1, j);
            } else {
                return;
            }
        }
    }
    
    private static class SortedItems {
        private DataItem[] items = new DataItem[3];
        private int size = 0;
        
        void add(DataItem item) {
            int j = size;
            while (j > 0 && items[j - 1].dData > item.dData) {
                items[j] = items[j - 1];
                j--;
            }
            items[j] = item;
            size++;
        }
        
        DataItem get(int i) {
            return items[i];
        }
    }

    private void splitAndInsert(Node23 thisNode, DataItem item) {
        // assumes node is full
        SortedItems sorted = new SortedItems();
        sorted.add(thisNode.removeItem());
        sorted.add(thisNode.removeItem());
        sorted.add(item);
        
        DataItem itemA = sorted.get(0);
        DataItem itemB = sorted.get(1);
        DataItem itemC = sorted.get(2);
//        Node23 child2 = thisNode.disconnectChild(2);
//        Node23 child3 = thisNode.disconnectChild(3);
        
        Node23 newRight = new Node23();
        newRight.insertItem(itemC);
        
        Node23 parent;
        if (thisNode == root) {
            root = new Node23();
            parent = root;
            root.connectChild(0, thisNode);
        } else {
            parent = thisNode.getParent();
        }
        
        thisNode.insertItem(itemA);
        if (parent.isFull()) {
            splitAndInsert(parent, itemB);
            parent.connectChild(2, newRight);
        } else {
            int k = parent.insertItem(itemB);
//            parent.connectChild(1, newRight);
            parent.connectChild(k + 1, newRight);
        }
//        int itemIndex = parent.insertItem(itemB);
//        int n = parent.getNumItems();
        
        // Move parent's connections one child to the right
//        for (int j = n - 1; j > itemIndex; j--) {
//            Node23 temp = parent.disconnectChild(j);
//            parent.connectChild(j + 1, temp);
//        }
//        parent.connectChild(itemIndex + 1, newRight);
        
        
//        newRight.connectChild(0, child2);
//        newRight.connectChild(1, child3);
    }

    /** Gets appropriate child of node during search for value. */
    private Node23 getNextChild(Node23 theNode, long value) {
        // assumes node is not empty, not full, not a leaf
        int numItems = theNode.getNumItems();
        int j = 0;
        while (j < numItems) {
            if (value < theNode.getItem(j).dData) {
                return theNode.getChild(j);     // return left child
            }
            j++;
        }
        return theNode.getChild(j);             // return right child
    }
}
