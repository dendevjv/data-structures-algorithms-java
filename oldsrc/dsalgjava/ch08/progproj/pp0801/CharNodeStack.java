package dsalgjava.ch08.progproj.pp0801;

public class CharNodeStack {
    private CharNode[] a;
    private int size;
    
    public CharNodeStack(int maxSize) {
        a = new CharNode[maxSize];
        size = 0;
    }
    
    public void push(CharNode n) {
        a[size++] = n;
    }
    
    public CharNode pop() {
        return a[--size];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
}
