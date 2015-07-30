package dsalgjava.ch10.lst1001;

public class Tree234 {
    private Node root = new Node();

    public int find(long key) {
        Node curNode = root;
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
        Node curNode = root;
        DataItem tempItem = new DataItem(dValue);
        
        while (true) {
            if (curNode.isFull()) {
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode, dValue);
            } else if (curNode.isLeaf()) {                  // go insert
                break;  
            } else {
                curNode = getNextChild(curNode, dValue);    // go to lower level
            }
        }
        
        curNode.insertItem(tempItem);
    }
    
    public void display() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node thisNode, int level, int childNumber) {
        System.out.print("level=" + level + " child=" + childNumber + " ");
        thisNode.display();
        
        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            Node nextNode = thisNode.getChild(j);
            if (nextNode != null) {
                recDisplayTree(nextNode, level + 1, j);
            } else {
                return;
            }
        }
    }

    private void split(Node thisNode) {
        // assumes node is full
        DataItem itemC = thisNode.removeItem();
        DataItem itemB = thisNode.removeItem();
        Node child2 = thisNode.disconnectChild(2);
        Node child3 = thisNode.disconnectChild(3);
        Node newRight = new Node();
        
        Node parent;
        if (thisNode == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, thisNode);
        } else {
            parent = thisNode.getParent();
        }
        
        int itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();
        
        // Move parent's connections one child to the right
        for (int j = n - 1; j > itemIndex; j--) {
            Node temp = parent.disconnectChild(j);
            parent.connectChild(j + 1, temp);
        }
        parent.connectChild(itemIndex + 1, newRight);
        
        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }

    /** Gets appropriate child of node during search for value. */
    private Node getNextChild(Node theNode, long value) {
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
