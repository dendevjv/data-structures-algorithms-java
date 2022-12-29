package dsalgjava.ch02.progproj.pp0201;

public class HighArrayApp {

    public static void main(String[] args) {
        HighArray arr = new HighArray(10);
        
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);
        
        arr.display();
        
        long m = arr.getMax();
        System.out.println("Maximum: " + m);
    }

}
