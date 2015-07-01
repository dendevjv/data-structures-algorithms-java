package dsalgjava.ch05.lst0501;

public class LinkList {
    protected Link first;
    
    public LinkList() {
        first = null;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void insertFirst(Link link) {
        link.next = first;
        first = link;
    }
    
    public Link deleteFirst() {
        Link link = first;
        if (first != null) {
            first = first.next;
        }
        return link;
    }
    
    public void display() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }
}
