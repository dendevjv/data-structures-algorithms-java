package dsalgjava.ch04.progproj.pp0402;

public class DequeApp {

    public static void main(String[] args) {
        DequeLong d = new DequeLong(5);
        
        d.insertLeft(10);
        d.insertLeft(20);
        d.insertLeft(30);
        while (!d.isEmpty()) {
            System.out.print(d.removeRight() + " ");
        }
        System.out.println();
        
        d.insertRight(10);
        d.insertRight(20);
        d.insertRight(30);
        while (!d.isEmpty()) {
            System.out.print(d.removeRight() + " ");
        }
        System.out.println();
    }

}
