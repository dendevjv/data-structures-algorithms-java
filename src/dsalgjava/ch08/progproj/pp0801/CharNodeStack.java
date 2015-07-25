package dsalgjava.ch08.progproj.pp0801;

public class CharNodeStack {
    private CharNode[] a;
    private int size;
    
    CharNodeStack(int maxSize) {
        a = new CharNode[maxSize];
        size = 0;
    }
    
    void push(CharNode n) {
        a[size++] = n;
    }
    
    CharNode pop() {
        return a[--size];
    }
    
    boolean isEmpty() {
        return size == 0;
    }
}
