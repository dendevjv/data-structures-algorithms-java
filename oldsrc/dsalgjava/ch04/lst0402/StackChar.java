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
    
    public void display(String text) {
        System.out.print(text);
        System.out.print("Stack (bottom-->top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(stackArr[i] + " ");
        }
        System.out.println();
    }
}
