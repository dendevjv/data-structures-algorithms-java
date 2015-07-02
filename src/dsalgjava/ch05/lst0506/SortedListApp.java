package dsalgjava.ch05.lst0506;

import dsalgjava.ch05.lst0503.Link;

public class SortedListApp {

    public static void main(String[] args) {
        SortedList list = new SortedList();
        
        list.insert(new Link(20));
        list.insert(new Link(40));
        list.display();
        
        list.insert(new Link(10));
        list.insert(new Link(30));
        list.insert(new Link(50));
        list.display();
        
        list.remove();
        list.display();
    }

}
