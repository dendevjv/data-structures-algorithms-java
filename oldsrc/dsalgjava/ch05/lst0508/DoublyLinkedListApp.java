package dsalgjava.ch05.lst0508;

public class DoublyLinkedListApp {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(new LinkD(22));
        list.insertFirst(new LinkD(44));
        list.insertFirst(new LinkD(66));
        list.insertLast(new LinkD(11));
        list.insertLast(new LinkD(33));
        list.insertLast(new LinkD(55));
        list.display();
        list.displayBackward();
        
        list.deleteFirst();
        list.deleteLast();
        list.display();
        
        list.deleteKey(11);
        list.display();
        
        list.insertAfter(22, new LinkD(111));
        list.display();
        
        list.deleteKey(33);
        list.display();
        
        list.deleteKey(44);
        list.display();
        
        list.insertAfter(111, new LinkD(333));
        list.display();
        
        list.insertAfter(1, new LinkD(444));
        list.display();
        list.displayBackward();
    }

}
