package dsalgjava.ch02.progproj.pp0203;

import dsalgjava.ch02.progproj.pp0202.HighArray;

public class HighArrayApp {

    private static final int SIZE = 10;

    public static void main(String[] args) {
        HighArray arr = new HighArray(SIZE);
        
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
        
        HighArray sorted = new HighArray(SIZE);
        long m;
        while ((m = arr.removeMax()) != -1) {
            sorted.insert(m);
        }
        
        sorted.display();
    }

}
