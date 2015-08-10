package dsalgjava.ch12.progproj.pp1204;

public class PriorityQueueTreeApp {

    public static void main(String[] args) {
        PriorityQueueBinaryTree q = new PriorityQueueBinaryTree();
        q.insert(30);
        q.insert(50);
        q.insert(10);
        q.insert(40);
        q.insert(20);
        
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }

}
