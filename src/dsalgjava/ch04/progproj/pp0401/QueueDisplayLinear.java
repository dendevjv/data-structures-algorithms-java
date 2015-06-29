package dsalgjava.ch04.progproj.pp0401;

import dsalgjava.ch04.lst0404.Queue;

public class QueueDisplayLinear {
    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.insert(10);
        q.insert(20);
        q.insert(30);
        q.displayLinear();
        q.display();
        
        q.remove();
        q.displayLinear();
        q.display();
        
        q.insert(40);
        q.displayLinear();
        q.display();
        
        q.remove();
        q.insert(50);
        q.displayLinear();
        q.display();
        
        q.remove();
        q.insert(60);
        q.displayLinear();
        q.display();
    }
}
