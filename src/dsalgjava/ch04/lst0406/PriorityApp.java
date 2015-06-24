package dsalgjava.ch04.lst0406;

public class PriorityApp {

    public static void main(String[] args) {
        PriorityQ q = new PriorityQ(5);
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
