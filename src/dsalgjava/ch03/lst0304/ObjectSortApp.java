package dsalgjava.ch03.lst0304;

import dsalgjava.ch02.lst0205.Person;

public class ObjectSortApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ArrayInOb arr = new ArrayInOb(100);
        
        arr.insert(new Person("Evans", "Patty", 24));
        arr.insert(new Person("Smith", "Doc", 59));
        arr.insert(new Person("Smith", "Lorraine", 37));
        arr.insert(new Person("Smith", "Paul", 37));
        arr.insert(new Person("Yee", "Tom", 43));
        arr.insert(new Person("Hashimoto", "Sato", 21));
        arr.insert(new Person("Stimson", "Henry", 29));
        arr.insert(new Person("Velasquez", "Jose", 72));
        arr.insert(new Person("Vang", "Minh", 22));
        arr.insert(new Person("Creswell", "Lucinda", 18));
        
        System.out.println("Before sorting:");
        arr.display();
        
        arr.insertionSort();
        
        System.out.println("After sorting:");
        arr.display();
    }

}
