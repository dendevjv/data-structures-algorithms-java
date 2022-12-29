package dsalgjava.ch05.lst0508;

public class DoublyLinkedList {
    private LinkD first;
    private LinkD last;
    
    public DoublyLinkedList() {
        first = null;
        last = null;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void insertFirst(LinkD link) {
        if (first != null) {
            link.next = first;
            first.prev = link;
        } else { // list is empty
            last = link;
        }
        first = link;
    }
    
    public void insertLast(LinkD link) {
        if (last != null) {
            link.prev = last;
            last.next = link;
        } else { // list is empty
            first = link;
        }
        last = link;
    }
    
    public LinkD deleteFirst() {
        LinkD link = first;
        first = link.next;
        if (first != null) {
            first.prev = null;
        } else { // empty list
            last = null;
        }
        return link;
    }
    
    public LinkD deleteLast() {
        LinkD link = last;
        last = link.prev;
        if (last != null) {
            last.next = null;
        } else { // empty list
            first = null;
        }
        return link;
    }
    
    public LinkD deleteKey(long key) {
        LinkD current = first;
        while (current != null && current.data != key) {
            current = current.next;
        }
        // current == null OR current.data == key
        if (current == null) {
            return null;
        } else if (current == first) {
            return deleteFirst();
        } else if (current == last) {
            return deleteLast();
        } else {
            current.next.prev = current.prev;
            current.prev.next = current.next;
            return current;
        }
    }
    
    public boolean insertAfter(long key, LinkD link) {
        LinkD current = first;
        while (current != null && current.data != key) {
            current = current.next;
        }
        // current == null OR current.data == key
        if (current == null) { // key not found
            return false;
        }
        link.prev = current;
        if (current.next == null) { // current is last
            last = link;
        } else {
            link.next = current.next;
            current.next.prev = link;
        }
        current.next = link;
        return true;
    }
    
    public void display() {
        System.out.print("List (first-->last): ");
        LinkD current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }
    
    public void displayBackward() {
        System.out.print("List (last-->first): ");
        LinkD current = last;
        while (current != null) {
            current.display();
            current = current.prev;
        }
        System.out.println();
    }
    
    public void insert(LinkD link) {
        
    }
}
