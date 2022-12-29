package dsalgjava.ch12.progproj.pp1204;

public class PriorityQueueBinaryTree {
    private Tree tree;
    
    public PriorityQueueBinaryTree() {
        tree = new Tree();
    }
    
    public void insert(int value) {
        tree.insert(value, 1.0);
    }
    
    public int remove() {
        return tree.removeMax().iData;
    }
    
    public boolean isEmpty() {
        return tree.isEmpty();
    }
}
