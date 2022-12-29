package dsalgjava.ch06.lst0607;

public class ParamStack {
    private Params[] arr;
    private int top;
    
    public ParamStack(int maxSize) {
        arr = new Params[maxSize];
        top = -1;
    }
    
    public void push(Params p) {
        arr[++top] = p;
    }
    
    public Params pop() {
        return arr[top--];
    }
    
    public Params peek() {
        return arr[top];
    }
}
