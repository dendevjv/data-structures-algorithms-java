package dsalgjava.ch12.shared;

/**
 * Represents a node containing integer key value. Used in a heap ADT.
 */
public class HpNode {
    private int key;

    public HpNode(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
