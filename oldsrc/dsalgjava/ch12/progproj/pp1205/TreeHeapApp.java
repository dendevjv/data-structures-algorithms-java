package dsalgjava.ch12.progproj.pp1205;

public class TreeHeapApp {

    public static void main(String[] args) {
        TreeHeap th = new TreeHeap();
        th.insert(30);
        th.insert(70);
        th.insert(20);
        th.insert(90);
        th.insert(10);
        th.insert(100);
        th.insert(50);
        th.displayTree();

        System.out.println("Changing 20 to 101");
        th.change(20, 101);
        th.displayTree();
        System.out.println("Changing 100 to 17");
        th.change(100, 17);
        th.displayTree();

        int removed;
        while (!th.isEmpty()) {
            removed = th.remove();
            System.out.println("-------------------------------------------------");
            System.out.println("Removed: " + removed);
            th.displayTree();
        }
    }

}
