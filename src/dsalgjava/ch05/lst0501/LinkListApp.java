package dsalgjava.ch05.lst0501;

public class LinkListApp {

    public static void main(String[] args) {
        LinkList list = new LinkList();
        
        list.insertFirst(new Link(22, 2.99));
        list.insertFirst(new Link(44, 4.99));
        list.insertFirst(new Link(66, 6.99));
        list.insertFirst(new Link(88, 8.99));
        
        list.display();
        
        while (!list.isEmpty()) {
            Link link = list.deleteFirst();
            System.out.print("Deleted ");
            link.display();
            System.out.println();
        }
        
        list.display();
    }

}
