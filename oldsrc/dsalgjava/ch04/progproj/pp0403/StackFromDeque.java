package dsalgjava.ch04.progproj.pp0403;

import dsalgjava.ch04.progproj.pp0402.DequeLong;

public class StackFromDeque extends DequeLong {

    public StackFromDeque(int maxSize) {
        super(maxSize);
    }

    public void push(long v) {
        insertRight(v);
    }
    
    public long pop() {
        return removeRight();
    }
    
    public static void main(String[] args) {
        StackFromDeque s = new StackFromDeque(3);
        s.push(10);
        s.push(20);
        s.push(30);
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }
}
