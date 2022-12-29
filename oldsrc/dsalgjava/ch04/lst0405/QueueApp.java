package dsalgjava.ch04.lst0405;

public class QueueApp {

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.display();
        
        queue.remove();
        queue.remove();
        queue.remove();
        queue.display();
        
        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        queue.insert(80);
        queue.display();
        
        System.out.println("Removing:");
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
        
        queue.display();    // This call prints incorrect size:
                            // size:6 when the queue is empty
    }

}
