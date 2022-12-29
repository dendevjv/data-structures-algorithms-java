package dsalgjava.ch04.lst0401;

import dsalgjava.ch04.shared.StackBase;

public class StackLong extends StackBase {
    private long[] stackArr;
    
    public StackLong(int s) {
        super(s);
        stackArr = new long[s];
    }
    
    public void push(long v) {
        stackArr[++top] = v;
    }
    
    public long pop() {
        return stackArr[top--];
    }
    
    public long peek() {
        return stackArr[top];
    }
    
    public void display(String text) {
        System.out.print(text);
        System.out.print("Stack (bottom-->top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(stackArr[i] + " ");
        }
        System.out.println();
    }
}
