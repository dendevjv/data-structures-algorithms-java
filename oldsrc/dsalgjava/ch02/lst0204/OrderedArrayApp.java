package dsalgjava.ch02.lst0204;

public class OrderedArrayApp {

    public static void main(String[] args) {
        OrderedArray arr = new OrderedArray(10);
        
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
        
        int searchKey = 11;
        int result = arr.find(searchKey);
        if (result != arr.size() && result != -1) {
            System.out.println("Found " + searchKey + " at " + result);
        } else {
            System.out.println("Can't find " + searchKey);
        }
        
        arr.delete(0);
        arr.delete(55);
        arr.delete(99);
        
        arr.display();
    }

}
