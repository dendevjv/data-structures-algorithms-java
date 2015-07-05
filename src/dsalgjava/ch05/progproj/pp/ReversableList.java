package dsalgjava.ch05.progproj.pp;

import dsalgjava.ch05.lst0503.Link;

public class ReversableList {
    protected Link first;
    private Link last;
    
    public ReversableList() {
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
    
    public void reverse() {
        if (first == null || first.next == null) {
            return;
        }
        Link willBeLast = first;
        first = reverse(first);
        last = willBeLast;
        last.next = null;
    }
    
    private Link reverse(Link head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Link tail = head.next;
        if (tail.next == null) {
            tail.next = head;
            head.next = null;
            return tail;
        }
        Link reversed = reverse(tail);
        tail.next = head;
        return reversed;
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
