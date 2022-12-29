package dsalgjava.ch12.progproj.pp1203;

public class PriorityQueueHeapApp {

    public static void main(String[] args) {
        PriorityQueueHeap q = new PriorityQueueHeap(5);
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
