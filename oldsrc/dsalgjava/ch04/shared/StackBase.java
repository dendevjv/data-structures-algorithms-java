package dsalgjava.ch04.shared;

public abstract class StackBase {
    protected int maxSize;
    protected int top;
    
    public StackBase(int maxSize) {
        this.maxSize = maxSize;
        top = -1;
    }
    
    public boolean isFull() {
        return top == maxSize - 1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public int size() {
        return top + 1;
    }
}
