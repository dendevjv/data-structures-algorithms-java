package dsalgjava.ch05.progproj.pp0501;

public class PriorityQueueApp {

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.add(3);
        pq.add(7);
        pq.add(2);
        pq.add(9);
        pq.add(5);
        pq.display();
        
        System.out.println("Removed " + pq.remove());
        System.out.println("Removed " + pq.remove());
        pq.display();
    }

}
