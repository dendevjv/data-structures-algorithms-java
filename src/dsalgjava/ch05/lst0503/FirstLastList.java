package dsalgjava.ch05.lst0503;

public class FirstLastList {
    private Link first;
    private Link last;
    
    public FirstLastList() {
        first = null;
        last = null;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void insertFirst(Link link) {
        if (isEmpty()) {
            last = link;
        }
        link.next = first;
        first = link;
    }
    
    public void insertLast(Link link) {
        if (isEmpty()) {
            first = link;
        } else {
            last.next = link;
        }
        last = link;
    }
    
    public Link deleteFirst() {
        Link link = first;
        first = first.next;
        if (link == last) {
            last = null;
        }
        return link;
    }
    
    public void display() {
        display("List (first-->last): ");
    }
    
    public void display(String prefixMessage) {
        System.out.print(prefixMessage);
        Link current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }
}
