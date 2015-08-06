package dsalgjava.ch11.progproj.pp1105;

/**
 * Node for binary search tree used in HashTableTree
 */
public class HtbtNode {
    int data;
    HtbtNode left;
    HtbtNode right;
    
    HtbtNode(int value) {
        data = value;
    }
    
    @Override
    public String toString() {
        return Integer.toString(data);
    }
}
