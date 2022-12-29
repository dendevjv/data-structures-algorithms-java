package dsalgjava.ch05.progproj.pp;

import dsalgjava.ch05.lst0503.Link;

public class ReversableListApp {

    public static void main(String[] args) {
        ReversableList list = new ReversableList();
        list.insertFirst(new Link(5));
        list.insertFirst(new Link(4));
        list.insertFirst(new Link(3));
        list.insertFirst(new Link(2));
        list.insertFirst(new Link(1));
        list.display();
        
        list.reverse();
        list.display();
    }

}
