package dsalgjava.ch02.progproj.pp0205;

import dsalgjava.tools.RandomArray;

public class OrderedArrayApp {

    public static void main(String[] args) {
        OrderedArray a1 = new OrderedArray(RandomArray.createLong(5, 11, 51));
        a1.display();
        OrderedArray a2 = new OrderedArray(RandomArray.createLong(5, 21, 61));
        a2.display();
        
        System.out.println("Merged:");
        OrderedArray a3 = a1.merge(a2);
        a3.display();
    }

}
