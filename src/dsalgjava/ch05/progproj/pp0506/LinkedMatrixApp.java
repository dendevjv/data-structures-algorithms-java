package dsalgjava.ch05.progproj.pp0506;

public class LinkedMatrixApp {

    public static void main(String[] args) {
        LinkedMatrix m = new LinkedMatrix();
        System.out.println("1 row:");
        m.insertRight(new LinkM(1));
        m.insertRight(new LinkM(3));
        m.insertRight(new LinkM(2));
        m.display();
        
        System.out.println("2 rows:");
        m.reset();
        m.insertDown(new LinkM(4));
        m.stepDown();
        m.insertRight(new LinkM(6));
        m.insertRight(new LinkM(5));
        m.display();
    }

}
