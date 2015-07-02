package dsalgjava.ch05.lst0506;

import dsalgjava.ch05.lst0503.Link;

public class SortedList {
    private Link first;
    
    public SortedList() {
        first = null;
    }
    
    public SortedList(Link[] arr) {
        for (int j = 0; j < arr.length; j++) {
            insert(arr[j]);
        }
    }
    
    public void insert(Link link) {
        Link prev = null;
        Link current = first;
        while (current != null && link.data > current.data) {
            prev = current;
            current = current.next;
        }
        link.next = current;
        if (prev == null) { //
            first = link;
        } else {
            prev.next = link;
        }
    }
    
    public Link remove() {
        Link link = first;
        first = first.next;
        return link;
    }
    
    public boolean isEmtpy() {
        return first == null;
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
