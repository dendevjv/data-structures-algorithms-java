package dsalgjava.ch05.lst0505;

public class LinkQueueApp {

    public static void main(String[] args) {
        LinkQueue queue = new LinkQueue();
        
        queue.insert(20);
        queue.insert(40);
        queue.display();
        
        queue.insert(60);
        queue.insert(80);
        queue.display();

        queue.remove();
        queue.remove();
        queue.display();
    }

}
