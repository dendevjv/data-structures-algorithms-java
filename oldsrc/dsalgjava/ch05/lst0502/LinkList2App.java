package dsalgjava.ch05.lst0502;

import dsalgjava.ch05.lst0501.Link;

public class LinkList2App {

    public static void main(String[] args) {
        LinkList2 list = new LinkList2();

        list.insertFirst(new Link(22, 2.99));
        list.insertFirst(new Link(44, 4.99));
        list.insertFirst(new Link(66, 6.99));
        list.insertFirst(new Link(88, 8.99));
        
        list.display();
        
        Link f = list.find(44);
        if (f != null) {
            System.out.print("Found: ");
            f.display();
            System.out.println();
        } else {
            System.out.println("Can't find.");
        }
        
        Link d = list.delete(66);
        if (d != null) {
            System.out.print("Deleted: ");
            d.display();
            System.out.println();
        } else {
            System.out.println("Can't find and delete.");
        }
        list.display();
        
        d = list.delete(88);
        if (d != null) {
            System.out.print("Deleted: ");
            d.display();
            System.out.println();
        } else {
            System.out.println("Can't find and delete.");
        }
        list.display();
    }

}
