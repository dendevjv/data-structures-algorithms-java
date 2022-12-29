package dsalgjava.ch08.progproj.pp0804;

public class ExprNodeStack {
    private ExprNode[] a;
    private int size;
    
    public ExprNodeStack(int maxSize) {
        a = new ExprNode[maxSize];
        size = 0;
    }
    
    public void push(ExprNode n) {
        a[size++] = n;
    }
    
    public ExprNode pop() {
        return a[--size];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int getSize() {
        return size;
    }
}
