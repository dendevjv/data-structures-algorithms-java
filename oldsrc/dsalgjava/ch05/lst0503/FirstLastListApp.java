package dsalgjava.ch05.lst0503;

public class FirstLastListApp {

    public static void main(String[] args) {
        FirstLastList list = new FirstLastList();

        list.insertFirst(new Link(22));
        list.insertFirst(new Link(44));
        list.insertFirst(new Link(66));
        list.display();
        
        list.insertLast(new Link(11));
        list.insertLast(new Link(33));
        list.insertLast(new Link(55));
        list.display();

        list.deleteFirst();
        list.deleteFirst();
        list.display();
    }

}
