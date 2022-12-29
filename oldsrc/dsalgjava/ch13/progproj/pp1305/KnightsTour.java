package dsalgjava.ch13.progproj.pp1305;

import java.util.ArrayDeque;
import java.util.Deque;

public class KnightsTour {

    public static void main(String[] args) {
        Board b = new Board(5);
        Knight k = new Knight();
        b.set(k, 0, 0);
        b.display();
        
        Deque<Knight> stack = new ArrayDeque<>();
        stack.push(k);
        
        while (!stack.isEmpty()) {
            Knight k1 = stack.peek();
            Knight k2 = b.nextMove(k1);
            if (k2 == null) {
                stack.pop();
                b.remove(k1);
                b.display();
            } else {
                k1.addOldMove(k2);
                stack.push(k2);
                b.set(k2);
                b.display();
                if (b.isFilled()) {
                    System.out.println("Board is filled!!!");
                    break;
                }
            }
        }
    }

}
