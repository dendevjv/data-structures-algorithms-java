package dsalgjava.ch04.lst0402;

import dsalgjava.ch04.shared.StackBase;

public class StackChar extends StackBase {
    private char[] stackArr;

    public StackChar(int maxSize) {
        super(maxSize);
        stackArr = new char[maxSize];
    }
    
    public void push(char v) {
        stackArr[++top] = v;
    }
    
    public char pop() {
        return stackArr[top--];
    }
    
    public char peek() {
        return stackArr[top];
    }

}
