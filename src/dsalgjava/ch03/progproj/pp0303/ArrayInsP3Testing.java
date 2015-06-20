package dsalgjava.ch03.progproj.pp0303;

import dsalgjava.tools.RandomArray;

public class ArrayInsP3Testing {

    private static final int SIZE = 20;

    public static void main(String[] args) {
        ArrayInsP3 arr = new ArrayInsP3(RandomArray.createLong(SIZE, 0, SIZE));
        arr.display();
        
        arr.insertionSort();
        arr.display();
        
        arr.noDups();
        arr.display();
    }

}
